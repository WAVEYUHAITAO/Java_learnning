package com.hito.lock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

//自旋锁
public class spinLockDemo {
    public static void main(String[] args) {
        spinLockDemo lock = new spinLockDemo();
        //自定义的自旋锁测试
        new Thread(()->{
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }

        },"T1").start();
        new Thread(()->{
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }
        },"T2").start();

    }
    //int  0
    // Thread null
    //自定义一个自旋锁
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    //加锁
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+" ==> myLock");
        //自旋锁
        while (!atomicReference.compareAndSet(null,thread)){

        }

    }
    //解锁
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+" ==> myUnLock");
        atomicReference.compareAndSet(thread,null);
    }
}
