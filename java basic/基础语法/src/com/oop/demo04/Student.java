package com.oop.demo04;
//类  private 私有
public class Student {
    //属性私有
    //名字
    private String name;
    //学号
    private int id;
    //性别
    private char sex;
    private int age;

    //提供一些可以操作这个属性的方法
    //提供一些public的 get. set 方法

    //get 获得这个数据
    public String getName(){
        return this.name;
    }
    //set 给这个数据设置值
    public void setName(String name){
        this.name = name;
    }

    //alt+insert

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {//在封装里增加条件判断
        if(age>120 || age<0){
            this.age = 3;
        }else{
            this.age = 120;
        }

    }

}
