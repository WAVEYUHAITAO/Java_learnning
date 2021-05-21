package com.thread;

/**
 * 生产者和消费者
 *
 */
public class demo04 {

    public static void main(String[] args) {
        Clerk c = new Clerk();
        //生产者
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (c){
                    while (true){ //无限循环代表无限生产次数
                        if(c.productNumber == 0){ //产品为0,开始生产
                            System.out.println("产品为0，开始生产");
                            while(c.productNumber <4){
                                c.productNumber++; //生产产品
                                System.out.println("库存"+c.productNumber);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println("产品数为"+c.productNumber+",结束生产");
                            c.notifyAll();//唤醒消费者
                        }else {
                            try {
                                c.wait(); //让生产者线程等待
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }, "生产者").start();
        //消费者
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (c){
                    while (true){ //无限循环代表无限消费次数
                        if(c.productNumber == 4){ //产品为4,开始消费
                            System.out.println("产品为4，开始消费");
                            while(c.productNumber >0){

                                //c.productNumber--;//消费产品
                                System.out.println("库存"+c.productNumber);
                                c.productNumber--;
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println("产品数为"+c.productNumber+",结束消费");
                            c.notifyAll();//唤醒生产者线程
                        }else {
                            try {
                                c.wait(); //让消费者线程等待
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }, "消费者").start();
    }
}
class Clerk{
    public static int productNumber = 0;
}