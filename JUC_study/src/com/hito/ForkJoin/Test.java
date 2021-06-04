package com.hito.ForkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //test1();  //普通for方法
        //test2();  //forkjoin 方法
        test3();    //Stream流方法

    }
    //普通程序员 3000块/月      sum=500000000500000000 时间：335
    public static void test1(){
        long sum = 0;
        long start = System.currentTimeMillis();
        for (long i = 1; i <=10_0000_0000 ; i++) {
            sum+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 时间："+(end-start));
    }
    //高级程序员 6000块/月   sum=500000000500000000 时间：469ms
    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        Demo01 demo01 = new Demo01(0, 10_0000_0000);
        ForkJoinTask<Long> submit = new ForkJoinPool().submit(demo01);
        long sum = submit.get();
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 时间："+(end-start));
    }
    //特级程序员 10000块/月 sum=500000000500000000 时间：262ms
    public static void test3()  {
        long start = System.currentTimeMillis();
        //Stream并行流（）
        long sum = LongStream.rangeClosed(0, 10_0000_0000).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 时间："+(end-start));
    }
}
