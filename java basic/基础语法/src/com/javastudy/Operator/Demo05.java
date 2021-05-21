package com.javastudy.Operator;

public class Demo05 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        System.out.println(a+=b);
        System.out.println(a-=b);
        System.out.println(""+a+b); //在前面加一个空的string,会把a和b也转换为string
        System.out.println(a+b+""); //后面加不会

    }
}
