package com.oop.demo05;
//重写是方法的重写，与属性无关
//继承
public class A extends B{
    // alt+insert
    //@Override //注解，有功能的注释
    //重写的方法名必须相同
    //参数列表必须相同
    //修饰符：范围可以扩大public>protected>Default>private
    //抛出的异常：范围， 可以被缩小，但不能扩大
    public void test() {
        System.out.println("A=>test()");
    }
}
