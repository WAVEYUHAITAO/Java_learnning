package com.oop.Demo06;

public class Application {
    public static void main(String[] args) {
        //student能调用的方法是自己的或者继承父类的
        Student s1 = new Student();
        //person父类型可以指向子类型，但是不能调用子类型独有的方法
        Person s2 = new Student();
        Object s3 = new Student();
        Person s4 = new Person();

        s1.run();
        s2.run();
        s4.run();
        s1.eat();
        ((Student)s2).eat(); //假如父类非要调用子类独有方法必须强转
        //s2.eat(); 报错
        //从s2.run和s4.run来看，父类型可以调用父子都有的方法
        //从s1.eat和s2.eat来看，父类不可以调用子类独有的方法，会报错
        //这就是多态
        //s3.run(); 报错
        //父子类型转换异常 ClassCastException!

        //只有方法有多态，属性没有多态

        //多态存在条件
        //1.有父子继承关系
        //2.方法需要重写
        //3.父类的引用指向子类对象 Father f1 = new Son();

        //哪些方法不能重写
        //1. static 方法 属于类，它不属于实例
        //2. final 常量
        //3. private 方法不能重写
    }
}
