package com.javastudy.method;

public class Demo01 {
    public static void main(String[] args) {
        int sum = add(1, 2);  //1,2就是实参
        System.out.println(sum);

        test();
    }
    //加法
    public static int add(int a, int b){    //加static变成累变量就可以在其他方法里调用，a,b是形参
        return a+b;
    }

    public static void test(){
        for (int j = 1; j <= 9; j++) {
            for (int i = 1; i <= j; i++) {
                System.out.print(i+"*"+j+"="+(i*j)+"\t");
            }
            System.out.println();
        }
    }
}
