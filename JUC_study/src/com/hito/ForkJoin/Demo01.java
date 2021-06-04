package com.hito.ForkJoin;

import java.util.concurrent.RecursiveTask;

//把大人物拆分为小任务，然后执行完得到各自结果后汇总
//ForkJoin特点：工作窃取   一个线程执行完了可以去运行别的线程没有完成的任务
//如何使用forkjoin
//1.forkjoinPool 通过它来执行
//2.计算任务 forkjoinPool.execute(ForkJoinTask task)
//3.计算类要继承
public class Demo01 extends RecursiveTask<Long> {
    private long start;
    private long end;

    //临界值
    private long temp= 10000;

    public Demo01(long start, long end){
        this.start = start;
        this.end = end;
    }
    //计算方法
    @Override
    protected Long compute() {
        if((end-start)<temp){
            long sum = 0;
            for(long i =start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }else { //forkjoin 类似于递归，把任务拆分，直到满足条件(end-start)<temp
            long middle = (start+end)/2; //中间值
            Demo01 task1 = new Demo01(start, middle);
            task1.fork();//拆分任务，把任务压入线程队列
            Demo01 task2 = new Demo01(middle+1, end);
            task2.fork();
            return task1.join()+task2.join();
        }
    }
}
