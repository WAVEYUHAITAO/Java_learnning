package com.hito.demo01;

import java.util.concurrent.TimeUnit;

public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        //java本身无法直接开启线程，而是通过调用本地native方法start0调用底层c++开启线程
        new Thread().start();
        System.out.println(Runtime.getRuntime().availableProcessors());

        //休眠
        TimeUnit.DAYS.sleep(1);
        TimeUnit.SECONDS.sleep(2);
    }
}
