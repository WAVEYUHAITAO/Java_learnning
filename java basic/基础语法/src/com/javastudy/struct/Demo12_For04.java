package com.javastudy.struct;

public class Demo12_For04 {
    public static void main(String[] args) {
        //打印99乘法表
        for (int j = 1; j <= 9; j++) {
            for (int i = 1; i <= j; i++) {
                System.out.print(i+"*"+j+"="+(i*j)+"\t");
            }
            System.out.println();
        }
    }
}
