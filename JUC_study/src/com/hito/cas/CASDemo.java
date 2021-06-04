package com.hito.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    //CAS compareAndSet:比较并交换!
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);

//        public final1  boolean compareAndSet(int expect, int update) {
//            return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
//        }

        //对应我们平时写的SQL：乐观锁

        //如果和期望值达到了，那么就更新，返回true。  否则，就不更新，返回false
        //ABA问题之捣乱的线程
        System.out.println(atomicInteger.compareAndSet(2020,2021));
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(2021,2020));
        System.out.println(atomicInteger.get());

        //期望的线程
        System.out.println(atomicInteger.compareAndSet(2020,6666));
        System.out.println(atomicInteger.get());
    }

}
//CAS：比较当前工作内存中的值和主内存中的值，如果这个值是期望的，那么执行操作。如果不是就一直循环
//缺点：1.由于底层是自旋锁，循环会耗时 2.一次性只能保证一个共享变量的原子性 3.ABA问题
//CAS  ABA问题（狸猫换太子）
//原子引用 ：带版本号的原子操作