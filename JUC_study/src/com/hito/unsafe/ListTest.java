package com.hito.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//java.util.ConcurrentModificationException 并发修改异常
public class ListTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");
        list.forEach(System.out::println);

        /**
         * ArrayList<String> list1 = new ArrayList<>(); //ArrayList线程下会有安全问题报错
         * 1.List<String> list1 = new Vector<>();//1.Vector解决方案，已过时
         * 2.List<String> list1 = Collections.synchronizedList(new ArrayList<>());//2.普通解决方案，使用Collections下的synchronizedList可以解决
         * 3.CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();
         *
         */
        //CopyOnWrite 写入时复制  COW 计算机程序设计领域的一种优化策略
        //多个线程调用的时候，list，读取的时候，固定的，写入（覆盖）
        //在写入的时候避免覆盖，造成数据问题
        //读写分离
        //CopyOnWriteArrayList 比 vector强在哪里
        //写入时复制用的是Reentrantlock  而 vector用的是synchronized锁

        CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list1.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list1);
            },String.valueOf(i)).start();

        }
    }
}
