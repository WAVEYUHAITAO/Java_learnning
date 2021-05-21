package com.oop.demo01;

public class Student {
    //方法
    public void say(){
        System.out.println("学生说话了");
    }
    //带static的方法是和类一起加载的
    public static void a(){
       // b();
    }
    //不带static的需要类实例化之后才存在
    public void b(){

    }


}
