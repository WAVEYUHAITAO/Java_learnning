package com.hito.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 异步调用： CompletableFuture
 * 异步执行
 * 失败回调
 * 成功回调
 *
 */
public class Demo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //发起一个请求
        //没有返回值的异步回调
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{

            System.out.println(Thread.currentThread().getName()+"runAsync=>Void");
        });
        //有返回值的异步回调
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"supplyAsync=>Integer");
            int i=10/0;
            return 1024;
        });

        System.out.println(completableFuture1.whenComplete((t,u)->{
            System.out.println("t=>"+t);//如果没有异常返回返回值，如果有异常返回null
            System.out.println("u=>"+u);//如果没有异常返回null，如果有异常返回异常信息
        }).exceptionally((e)->{
            System.out.println(e.getMessage());
            return 233;//失败的返回值
        }).get());
        System.out.println("1111");
        completableFuture.get();//获取执行结果
    }
}
/**
 * success 200
 * fail 500 404
 */