package com.hito.pool;

import java.security.AccessController;
import java.util.concurrent.*;

//Executors 工具类，3大方法
//使用了线程池之后，使用线程池来创建线程
public class Demo01 {
    public static void main(String[] args) {
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();//单个线程
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);//创建一个固定的线程池的大小
        //ExecutorService threadPool = Executors.newCachedThreadPool();//可伸缩的,遇强则强

        //最大线程到底该如何定义 （调优）
        //1. CPU密集型, 几核， 就是几， 可以保持CPU效率最高
        System.out.println(Runtime.getRuntime().availableProcessors());//获取cpu核数
        //2. IO密集型 > 判断你程序中十分耗IO的线程 一般是2倍
        // 程序 15个大型任务 IO十分占用资源！
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                Runtime.getRuntime().availableProcessors(),
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());  //4种拒绝策略，银行满了，还有人进来，不处理这个人，抛出异常
                                                             //CallerRunsPolicy() 哪来的去哪

        try {
            for (int i = 0; i < 8; i++) {
                //使用了线程池之后，使用线程池来创建线程
                //当创建的线程> maximumPoolSize+BlockingDeque时，抛出拒绝策略的异常
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池用完，程序结束，关闭线程池
            threadPool.shutdown();
        }
    }
}

    /**
     * public ThreadPoolExecutor(int corePoolSize, //核心线程池大小
     *                               int maximumPoolSize, //最大线程池大小   Integer.MAX_VALUE=约等于21亿
     *                               long keepAliveTime, //超时了没人调用就会释放
     *                               TimeUnit unit, //超时单位
     *                               BlockingQueue<Runnable> workQueue,  //阻塞队列
     *                               ThreadFactory threadFactory, //线程工厂，创建线程的，一般不用动
     *                               RejectedExecutionHandler handler//拒绝策略) {
     *         if (corePoolSize < 0 ||
     *                 maximumPoolSize <= 0 ||
     *                 maximumPoolSize < corePoolSize ||
     *                 keepAliveTime < 0)
     *             throw new IllegalArgumentException();
     *         if (workQueue == null || threadFactory == null || handler == null)
     *             throw new NullPointerException();
     *         this.acc = System.getSecurityManager() == null ?
     *                 null :
     *                 AccessController.getContext();
     *         this.corePoolSize = corePoolSize;
     *         this.maximumPoolSize = maximumPoolSize;
     *         this.workQueue = workQueue;
     *         this.keepAliveTime = unit.toNanos(keepAliveTime);
     *         this.threadFactory = threadFactory;
     *         this.handler = handler;
     *     }
     *
     */

