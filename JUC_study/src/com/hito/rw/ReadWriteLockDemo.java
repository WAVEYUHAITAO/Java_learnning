package com.hito.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * ReadWriteLock
 */

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        MyCache1 myCache1 = new MyCache1();
        //写入
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(()->{
                myCache1.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }
        //读取
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }

}

/**
 * 自定义缓存
 */
//没加锁的
class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    // 存，写
    public void put(String key, Object value){
        System.out.println(Thread.currentThread().getName()+"写入"+key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName()+"写入成功");
    }
    // 取，读
    public void get(String key){
        System.out.println(Thread.currentThread().getName()+"读取"+key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取成功");
    }
}

//加锁的
class MyCache1{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReadWriteLock lock =  new ReentrantReadWriteLock();
    //
    // 存，写
    public void put(String key, Object value){
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+"写入"+key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName()+"写入成功");

        lock.writeLock().unlock();

    }
    // 取，读
    public void get(String key){
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+"读取"+key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取成功");

        lock.readLock().unlock();
    }
}