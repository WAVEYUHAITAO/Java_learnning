package com.thread;


public class demo01 {
    public static void main(String[] args) {
        Thread t0 = new TestThread(); //继承Thread类的线程
        t0.start();//启动线程,相当于在main方法之外开启一个支流, t0.start()之后的main方法的其他代码与run方法的代码并行运行，异步执行！没有先后关系
        Thread t1 = new TestThread();
        t1.start();
        Thread t2 = new TestThread();
        t2.start();
        Thread t3 = new Thread(new TestRunnable());//通过Runnable方法来实现多线程,一般采用实现接口方式实现多线程,因为java是单继承,实现接口不影响继承别的类
        t3.start();
        Thread t4 = new Thread(new TestRunnable(), "t-1"); //传入线程名称
        t4.start();
        Runnable run = new TestRunnable();//t5,t6共享count值， 一个加5次
        Thread t5 = new Thread(run, "t-2"); //传入线程名称
        t5.start();
        Thread t6 = new Thread(run, "t-3"); //传入线程名称
        t6.start();

        System.out.println("t0的优先级"+t0.getPriority());
        System.out.println("------------------");
        System.out.println("------------------");
        System.out.println("------------------");

    }
}
