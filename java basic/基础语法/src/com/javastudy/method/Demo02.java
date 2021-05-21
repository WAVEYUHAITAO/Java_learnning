package com.javastudy.method;

public class Demo02 {
    public static void main(String[] args) {
        System.out.println(max(5   ,2));
    }
    public static double max(double a, double b){
        double result = 0;
        if(a==b){
            System.out.println("a=b");
            return 0; //终止方法
        }
        if(a>b){
            result = a;
        }else{
            result = b;
        }
        return  result;
    }
    public static int max(int a, int b){  //方法重载
        int result = 0;
        if(a==b){
            System.out.println("a=b");
            return 0; //终止方法
        }
        if(a>b){
            result = a;
        }else{
            result = b;
        }
        return  result;
    }
}
