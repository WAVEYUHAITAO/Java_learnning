package com.oop.demo02;
//一个项目就一个main方法
public class Application {
    public static void main(String[] args) {
        //类：抽象的,实例化
        //类实例化后会返回一个自己的对象
        //student对象就是一个student类的具体实例
        Student xiaoMing = new Student();
        Student xiaoHong = new Student();
        xiaoMing.study(); //小明未赋值
        xiaoMing.name="小明";
        xiaoMing.age=3;
        xiaoMing.study(); //赋值后的小明
        System.out.println(xiaoMing.name);
        System.out.println(xiaoMing.age);
        Person person = new Person("haitao");

        System.out.println(person.name);


    }
}
