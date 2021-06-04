package com.hito.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo02 {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();
        new Thread(()->{
            phone.sms();
        },"A").start();
        new Thread(()->{
            phone.sms();
        },"B").start();
    }
}
//可重入锁
class Phone2{
    Lock lock = new ReentrantLock();
    public void sms(){
        lock.lock(); //这里两个方法是两把不同的锁，锁必须配对 而synchronized锁的是方法的调用者(锁对象)，是同一个锁！

        try {
            System.out.println(Thread.currentThread().getName()+" sms");
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    public void call(){
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName()+" call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
