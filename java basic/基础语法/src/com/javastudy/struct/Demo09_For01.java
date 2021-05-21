package com.javastudy.struct;

public class Demo09_For01 {
    public static void main(String[] args) {
        int a = 1; //初始化条件

        while(a<=100){//条件判断
            System.out.println(a); //循环体
            a+=2; //迭代

        }
        System.out.println("循环结束");

        for(int i = 1;i<=100;i++){
            System.out.println(i);
        }
        for (int i = 0; i < 100; i++) {

        }

        //死循环
        for(;;){

        }
    }
}
