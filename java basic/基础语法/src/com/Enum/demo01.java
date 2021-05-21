package com.Enum;

public class demo01 {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        spring.showInfo();

        Season summer = Season.SUMMER;
        summer.showInfo();

        Season autumn = Season.AUTUMN;
        autumn.showInfo();

        Season winter = Season.WINTER;
        winter.showInfo();

        winter.test();
    }
}

enum Season implements ITest{  //枚举类
    SPRING("春天","春暖花开"),
    SUMMER("夏天","炎炎夏日"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","寒风凛冽");



    private final String name;
    private final String desc;

    //枚举类的构造方法不允许实例化，默认为private
    private Season(String name , String desc){  //枚举类的构造函数一定是私有的，这里写不写都一样，外部不可以实例化对象来访问这个构造函数
        this.name = name;
        this.desc = desc;
    }

    public void showInfo(){
        System.out.println(this.name+": "+this.desc);
    }


    @Override
    public void test() {
        System.out.println("这是实现的ITest接口的方法");
    }
}

interface ITest{
    void test();
}
