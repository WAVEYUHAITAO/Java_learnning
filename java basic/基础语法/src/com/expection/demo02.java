package com.expection;

public class demo02 {

    public static void main(String[] args) {
        int a = 1;
        int b = 0;
//        try {
            new demo02().test(1,0);
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        }
//        try {
//
//            if(b==0){//throw throws
//                throw new ArithmeticException(); //主动抛出异常
//            }
//
//            System.out.println(a/b);
//        } catch (Exception e) {
//            e.printStackTrace();//打印错误的栈信息
//        } finally {
//
//        }
    }
    //假设这方法中，处理不了这个异常，方法上抛出异常
    public void  test(int a, int b){
        if(b==0){//throw throws
            throw new ArithmeticException(); //主动抛出异常,一般在方法中使用
        }
//        System.out.println(a/b);//没有这行也会主动抛出异常
    }
}
