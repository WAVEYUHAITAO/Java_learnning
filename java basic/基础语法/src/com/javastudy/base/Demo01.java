package com.javastudy.base;

public class Demo01 {
    public static void main(String[] args) {
        String a="hello";
        System.out.println(a);

        //整数
        int num1= 10;   //4byte
        byte num2=20;   //1byte(字节)=8bit(位)
        short num3= 30; //2byte
        long num4=30L; //Long类型要在数字后面加个L,8byte

        //小数：浮点数
        float num5= 50.01F;//float类型要在数字后面加个F,4byte
        double num6=3.141592653;//8byte

        //字符
        char name='A'; //2byte
        //字符串，String不是关键字，是类
    }
}
