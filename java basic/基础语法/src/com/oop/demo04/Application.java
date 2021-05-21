package com.oop.demo04;

public class Application {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("海涛");

        System.out.println(s1.getName());

        s1.setAge(999); //不合法
        System.out.println(s1.getAge());
    }
}
/*
1.提高程序的安全性，保护数据
2.隐藏代码的实现细节
3.统一接口
4.系统可维护增加了
5.隐藏数据，只能通过方法接口来操作数据
 */