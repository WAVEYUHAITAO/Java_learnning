package com.expection;

//自定义的异常类
public class demo03 extends Exception{

    //传递数字》10；抛出异常
    private int detail;

    public demo03(int a){
        this.detail = a;
    }
    //toString


    @Override
    public String toString() {
        return "demo03{" +
                "detail=" + detail +
                '}';
    }
}
