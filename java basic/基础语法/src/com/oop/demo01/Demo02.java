package com.oop.demo01;

public class Demo02 {
    public static void main(String[] args) {
        //静态方法 static
        //类中的静态方法才能通过类.方法名调用
        //Student.say();

        //非静态方法
        //实例化这个类来调用方法 new
        //对象类型 对象名 =对象值

        Student student = new Student();
        student.say();
    }

}
