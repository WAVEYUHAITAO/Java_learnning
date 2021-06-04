package com.hito.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo02 {
    public static void main(String[] args) {
        //并发：多线程操作统一而资源类，吧资源类丢入线程
        Ticket02 ticket02 = new Ticket02();
        new Thread(()->{for (int i = 0; i < 40; i++) ticket02.sale();},"A").start();
        new Thread(()->{for (int i = 0; i < 40; i++) ticket02.sale();},"B").start();
        new Thread(()->{for (int i = 0; i < 40; i++) ticket02.sale();},"C").start();
    }
}
//lock的使用
class Ticket02{
    private int number = 50;
    //1. new ReentrantLock();
    Lock lock =new ReentrantLock();
    public void sale(){
        //2.先加锁
        lock.lock();
        //lock.tryLock(); //trylock是判断是否获得到锁，返回的是布尔值 lock.trylock(10,TimeUnit.MILLISECONDS),每0.01秒获取一次值看是否获得锁
        //3.业务代码块放在try catch finally里
        try {
            if(number>0){
                System.out.println(Thread.currentThread().getName()+"当前有"+(number--)+"票，卖出1票，剩余："+number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//4.解锁
        }
    }
}