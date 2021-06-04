package com.hito.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicReference {
    public static void main(String[] args) {
        //AtomicStampedReference 注意，如果泛型是一个包装类，注意对象的引用问题，这里Integer是int的包装类，取值在-128到127，如果超出会重新new Ingeter(),可以查看Integer源码
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(127,1);//原始数值+时间戳

        new Thread(()->{
            System.out.println("a1=>"+atomicStampedReference.getStamp());//获得版本号

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean b = atomicStampedReference.compareAndSet(127, 128, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(b);
            System.out.println("a2=>"+atomicStampedReference.getStamp());
            boolean c = atomicStampedReference.compareAndSet(128, 127, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(c);//这里因为128超过包装类Integer范围，转换失败，stamp也因此没有增加
            System.out.println("a3=>"+atomicStampedReference.getStamp());
        },"a").start();

//        new Thread(()->{
//            int stamp = atomicStampedReference.getStamp(); //获得版本号
//            System.out.println("b1=>"+stamp);
//
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            atomicStampedReference.compareAndSet(2020,2022,stamp,stamp+1);
//            System.out.println("b2=>"+atomicStampedReference.getStamp());
//        },"b").start();
    }
}
