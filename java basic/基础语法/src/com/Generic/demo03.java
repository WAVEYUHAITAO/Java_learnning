package com.Generic;

import java.util.ArrayList;
import java.util.List;

public class demo03 {
    public static void main(String[] args) {
        Dd dd = new Dd();
        List<String> l1 = new ArrayList<String>();
        dd.test(l1);

        List<Integer> l2 = new ArrayList<Integer>();
        dd.test(l2);

        dd.test1(new ArrayList<C1>()); //测试test1 里面放C1 D1 没问题
        dd.test1(new ArrayList<D1>());
        //dd.test1(new ArrayList<B3>()); //test1 放B3 ，是C1的父类，报错

        dd.test2(new ArrayList<C1>());
        dd.test2(new ArrayList<A1>());
        dd.test2(new ArrayList<B3>());
        //dd.test2(new ArrayList<D1>()); //test2 放D1 ，是C1的子类，报错

        List<IAImpl> l3 = new ArrayList<IAImpl>();
        List<IA> l4 = new ArrayList<IA>();
        dd.test3(l3);
        dd.test3(l4);
    }
}

class Dd{
    public void test(List<?> list){ //test方法需要一个list集合的参数，不确定list集合到底是存的数据类型是什么

    }

    public void test1(List<? extends C1> list){} //list参数的元素数据类型是C1及其子类，C1 D1
    public void test2(List<? super C1> list){} //list参数的元素数据类型是C1及其父类类，C1 B3 A1

    public void test3(List<? extends IA> list){//list参数的元素数据类型是IA的实现类

    }

}

class A1{}

class B3 extends A1{}

class C1 extends B3{}

class D1 extends C1{}

interface IA{}

class IAImpl implements IA{

}