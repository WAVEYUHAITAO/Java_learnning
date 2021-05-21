package com.expection;

public class Test {
    //可能会存在异常的方法
    public static void test(int a) throws demo03 {
        System.out.println("传递的参数是"+a);
        if(a>10){
            throw new demo03(a); //抛出异常要么当场解决try catch,要么就向上抛出由调用方法的人去解决
        }
        System.out.println("ok");
    }

    public static void main(String[] args) {

        try {
            test(11); //这里调用含有异常抛出的方法，需要由try catch包裹
        } catch (demo03 e) {
            System.out.println(e);
        }

    }
}
