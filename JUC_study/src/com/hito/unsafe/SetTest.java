package com.hito.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetTest {
    public static void main(String[] args) {

        //java.util.ConcurrentModificationException 出现并发修改异常
        /**
         * 1.HashSet<String> set = new HashSet<>();
         * 2.Set<String> set = Collections.synchronizedSet(new HashSet<>());
         */

        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
