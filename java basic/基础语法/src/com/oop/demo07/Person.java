package com.oop.demo07;

public class Person {
    //2 赋初始值
    {
        //代码块（匿名代码块）
        System.out.println("匿名代码块");
    }
    //1 第一个输出，且只执行一次！！！
    static{
        //静态代码块
        //类一加载就执行，永久只执行一次
        System.out.println("静态代码块");
    }
    //3
    public Person(){
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        System.out.println("=====================");
        Person person2 = new Person();//第二次static代码块不输出了，所以说static代码块只执行一次

    }
}
