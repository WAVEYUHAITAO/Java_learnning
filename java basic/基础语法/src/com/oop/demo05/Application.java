package com.oop.demo05;

public class Application {
    public static void main(String[] args) {
        Student student = new Student();
        student.say();
        System.out.println(student.getMoney());

        student.test("海涛");
        //静态方法和非静态方法区别很大：
        //静态方法的调用只和左边，定义的数据类型有关
        //非静态方法：重写了
        //子类的引用不可以指向父类
        //[A a =new B()]不可以
        A a = new A();
        a.test();


        //父类的引用可以指了子类
        B b = new A(); //非静态方法中，子类才重写了父类的方法
        b.test();
    }
}

