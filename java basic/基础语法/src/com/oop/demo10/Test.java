package com.oop.demo10;

public class Test {
    public static void main(String[] args) {
        //没有名字去初始化类,不用把实例保存到变量中
        new Apple().eat();//匿名内部类
        new UserService(){
            @Override
            public void hello() {

            }
        };
    }
}

class Apple{
    public void eat(){
        System.out.println("1");
    }
}

interface UserService{
    void hello();
}