package com.annotation;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;

public class demo01 {
    @SuppressWarnings("unused")  //抑制警告
    public static void main(String[] args) {
        new TestB().test1();

        @SuppressWarnings("rawtypes") //抑制警告
        List list = new ArrayList();
    }
}

class TestA{
    public void test(){

    }
}

class TestB extends TestA{

    @TestAnn(id=100,desc="姓名")
    String name;



    @Override  //重写注解
    public void test() {
        super.test();
    }
    @Deprecated //过时注解
    public void test1(){
        System.out.println("过时的方法");
    }
}

//自定义注解
@Target(ElementType.FIELD) //这个注解类是给其他类的属性做注解, 如果要给方法做注解需要改ElementType
@Retention(RetentionPolicy.RUNTIME) //定义注解的声明周期
@Documented  //程序是否要抽取到doc文档中
@interface TestAnn{
    public int id() default 0;

    public String desc() default "";
}


