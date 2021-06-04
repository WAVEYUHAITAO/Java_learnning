package com.hito.unsafe;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();//初始化容量，负载因子,多线程不安全
        ConcurrentHashMap<String,String> hashMap1 = new ConcurrentHashMap<>();//多线程安全
        for (int i = 0; i < 30; i++) {

            new Thread(()->{
                hashMap.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
                System.out.println(hashMap);
            },String.valueOf(i)).start();
        }
    }
}
