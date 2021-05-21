package com.oop.demo05;
//父类，基类
//在java中，所有的类，都默认直接或者间接继承object类
public class Person {

    //public
    //protected
    //default
    //private
    //私有的东西无法被继承private
    private int money = 10_0000_0000; //私有属性不可以直接操作，需要用set/get
    public void say(){
        System.out.println("说了一句话");
    }

    public Person() {
        System.out.println("person无参构造执行了");
    }

    //alt+insert 调用get、set
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    protected String name = "haitao";
}
