package com.oop.demo01;

//Demo01类
public class Demo01 {
    //main方法
    public static void main(String[] args) {
        System.out.println(sayHello());
        System.out.println(max(3,5));
    }
    /*
    修饰符 返回值类型 方法名(...){
        //方法体
        return 返回值;
    }
     */

    public static String sayHello(){
        return "Hello world.";
    }
    public static int max(int a, int b){
        return a>b? a : b; //三元运算符

    }
}
