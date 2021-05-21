package com.oop.demo09;

public interface UserService {
    //常量~ public static final
    public static final int age = 99;
    int age1 = 99;

    //接口中的所有定义其实都是抽象的 public
    //接口中的方法就相当于于约束，由实现类去重写
    public abstract void run(); //接口中默认是抽象的，所以可以省略 public abstract
    void run(String name);


    void add(String name);
    void delete(String name);
    void update(String name);
    void query(String name);
}
