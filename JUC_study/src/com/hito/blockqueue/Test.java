package com.hito.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //Collection
        //List
        //Set
        //Queue->BlockingQueue, Deque, AbstractQueue

        new Test().test1();
        new Test().test2();
        new Test().test3();
        new Test().test4();
    }
    //抛出异常
    public void test1(){
        //队列大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        //FIFO 先进先出
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        //抛出异常 Queue full
        //System.out.println(blockingQueue.add("d"));
        System.out.println("===========================");
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

    }

    public void test2(){
        //队列大小
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println("==========================");
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));
        //blockingQueue.offer("d") 不抛出异常而是打印false
        System.out.println(blockingQueue.element());//返回队首元素，跟peek()的唯一区别是如果队列为空抛出异常
        System.out.println(blockingQueue.peek());//返回队首元素，如果队列为空返回null
        System.out.println("==========================");
        System.out.println(blockingQueue.poll());   //返回移除的元素
        System.out.println(blockingQueue.element());//返回队首元素
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());//也不抛出异常而是返回null


    }

    public void test3() throws InterruptedException {
        //队列大小
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println("==========================");
        //等待，阻塞（一直阻塞）
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //blockingQueue.put("d"); //队列没有位置了，一直阻塞
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        //System.out.println(blockingQueue.take());//队列都取出后，也是一直阻塞
    }

    //带参数的offer
    public void test4() throws InterruptedException {
        //队列大小
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println("==========================");
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d",2, TimeUnit.SECONDS)); //offer用法的重载，放入队列时等待2秒，如果放不进去返回false
        //blockingQueue.offer("d") 不抛出异常而是打印false
        System.out.println("==========================");
        System.out.println(blockingQueue.poll());   //返回移除的元素
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));   //也不抛出异常而是返回null


    }
}
