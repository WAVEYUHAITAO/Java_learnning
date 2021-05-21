package com.javastudy.struct;

public class Demo14_printtri {
    //打印三角形
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {            //外面for循环定义有多少行
            for (int j = 5; j >= i; j--) {        //里面定义每一行怎样输出
                System.out.print(" ");            //这里用Print输出完不换行
            }
                            //这里输出每一行后换行
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
