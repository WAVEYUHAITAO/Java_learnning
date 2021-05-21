package com.oop.demo10;

public class Application {
    public static void main(String[] args) {
        //new
        //Outer outer = new Outer();

        //通过外部类来实例化内部类~成员内部类 非静态
        Outer.Inner inner = new Outer().new Inner();
        inner.in();
        inner.getID();
        //静态
        Outer.Inner1 inner1 = new Outer.Inner1();
        inner1.in();
    }
    //局部内部类
    public void method(){
       class Inner{
            public void in(){

            }
        }
    }
}

//一个java类中可以有多个class类，但只能有一个public class
class A{

}

