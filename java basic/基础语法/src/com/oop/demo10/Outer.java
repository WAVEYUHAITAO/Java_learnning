package com.oop.demo10;

public class Outer {

    private int id=10;
    public void out(){
        System.out.println("外部类的方法");
    }

    public class Inner{
        public void in(){
            System.out.println("内部类的方法");
        }
        //获得外部类的私有属性，私有方法
        public void getID(){
            System.out.println(id);
        }
    }

    public static class Inner1{
        public void in(){
            System.out.println("静态内部类的方法");
            //静态内部类无法调用私有属性因为私有属性没static
        }
    }
}
