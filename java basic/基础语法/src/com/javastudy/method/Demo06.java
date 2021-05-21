package com.javastudy.method;

public class Demo06 {
    //5! 5*4*3*2*1
    public static void main(String[] args) {
        System.out.println(f(5));
    }
    public static int f(int n){  //递归
        if(n==1){
            return 1;  //当不等于1的时候持续调用自身，直到等于1
        }else{
            return n*f(n-1);
        }
    }
}
