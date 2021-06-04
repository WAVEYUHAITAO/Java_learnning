package com.hito.pc;
/*
 *线程之间的通信问题，生产者和消费者问题
 * 线程交替执行 A B操作同一个变量 num=0
 * A num+1
 * B num-1
 */
public class A {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            while(true) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            while (true){
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            while (true){
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            while (true){
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
//等待业务通知
class Data{//数字类 资源类
    private int num = 0;
    //+1
    public synchronized void increment() throws InterruptedException {
        if(num==0){
            for (int i = 0; i < 5; i++) {
                num++;
                System.out.println(Thread.currentThread().getName()+"=>"+num);
                Thread.sleep(1000);
            }

            //通知其他线程，我+1完毕了
            this.notify();
        }else {
            //等待
            this.wait();
        }


        Thread.sleep(1000);


    }
    //-1
    public synchronized void decrement() throws InterruptedException {
        if(num!=0){
            for (int i = 0; i < 5; i++) {
                num--;
                System.out.println(Thread.currentThread().getName()+"=>"+num);
                Thread.sleep(1000);
            }

            //通知其他线程，我-1完毕了
            this.notify();
        }else{
            //等待
            this.wait(); //线程的wait方法写在if里容易出现虚假唤醒
        }


        Thread.sleep(1000);

    }

}
