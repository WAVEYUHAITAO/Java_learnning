package com.hito.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //new Thread(new MyThread()).start();
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread);
        new Thread(futureTask,"A").start(); //怎么启动callable
        String o = (String) futureTask.get(); //get方法可能产生阻塞，如果是个耗时的方法
        System.out.println(futureTask.get());
    }
}

class MyThread implements Callable<String> {

    @Override
    public String call(){
        System.out.println("call()");
        return "1024";
    }
}
