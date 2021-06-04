package com.lock8;

import java.util.concurrent.TimeUnit;
/*
8锁，就是关于锁的8个问题
1.标准情况下，两个线程先打印 发短信还是打电话  1.发短信 2.打电话
2.发短信延迟4秒，两个线程先打印 发短信还是打电话  1.发短信 2.打电话
3.增加一个普通方法，限制性发短信还是hello   1. hello 2.发短信
4.如果两个对象，两个同步方法先 发短信还是打电话 1.打电话 2.发短信
 */
public class Test2 {
    public static void main(String[] args) {
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();

        new Thread(phone1::sendSms).start();
        new Thread(()-> phone2.hello()).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(phone2::call).start();
    }

}
class Phone2{
    //synchronized 锁的对象是方法的调用者
    //两个方法用的是同一个锁，谁先拿到谁执行
    public synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    public synchronized void call(){
        System.out.println("打电话");
    }
    //hello()方法没有锁，不是同步方法，不受锁的影响
    public void hello(){
        System.out.println("hello");
    }
}
