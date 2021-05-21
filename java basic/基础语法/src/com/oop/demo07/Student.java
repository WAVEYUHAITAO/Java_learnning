package com.oop.demo07;

public class Student extends Person {


    private  static int age; //静态变量  多线程！
    private  double score;//非静态变量

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(Student.age);
        System.out.println(student.score);
        System.out.println(student.age);

        Student.run();//static和类一起加载
        student.go();//必须实例化类才能加载
    }

    public static void run(){  //static和类一起加载

    }

    public void go(){   //必须实例化类才能加载
        System.out.println("go");
    }
}
