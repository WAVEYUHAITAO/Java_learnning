package com.hito.add;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //总数是6
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Go Out");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();//等待计数器归零，然后再乡下执行
        //每次有线程调用countDown()数量-1，当计数器变为0，唤醒countDownLatch.await(); 然后程序继续执行
        System.out.println("Close Door");//-1
    }
}
