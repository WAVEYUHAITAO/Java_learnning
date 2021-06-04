package com.hito.demo01;

/*
线程就是一个单独的资源类，没有任何附属的操作
1.属性，方法
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        //并发：多线程操作统一而资源类，吧资源类丢入线程
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            } },"A").start();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            } },"B").start();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            } },"C").start();

    }
}

class Ticket{
    private int number = 50;

    public synchronized void sale(){
        if(number>0){
            System.out.println(Thread.currentThread().getName()+"当前有"+(number--)+"票，卖出1票，剩余："+number);
        }
    }
}