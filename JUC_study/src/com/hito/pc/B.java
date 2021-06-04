package com.hito.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class B {
    public static void main(String[] args) {
        Data2 data2 = new Data2();
        new Thread(()->{
            while(true) {
                try {
                    data2.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            while (true){
                try {
                    data2.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            while (true){
                try {
                    data2.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            while (true){
                try {
                    data2.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
//等待业务通知
class Data2{//数字类 资源类
    private int num = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    //+1
    public void increment() throws InterruptedException {
        lock.lock();

        try {
            if(num==0){
                for (int i = 0; i < 5; i++) {
                    num++;
                    System.out.println(Thread.currentThread().getName()+"=>"+num);
                    Thread.sleep(1000);
                }
                condition.signal();

            }else {
                condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }





    }
    //-1
    public void decrement() throws InterruptedException {

        lock.lock();

        try {
            if(num!=0){
                for (int i = 0; i < 5; i++) {
                    num--;
                    System.out.println(Thread.currentThread().getName()+"=>"+num);
                    Thread.sleep(1000);
                }
                condition.signal();

            }else{
                condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

}
