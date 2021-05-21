package com.javastudy.base;

public class Demo04 {
    //类变量 static
    static double salary =2500;
    // final:常量   修饰符，不存在先后顺序
    static final double PI = 3.14;
    //属性：变量

    //实例变量：从属于对象；如果不初始化，会赋予这个类型的默认值。
    //布尔值：默认是false
    //除了基本类型，其余的默认值都是null
    String name;
    int age;
    public static void main(String[] args) {
        //局部变量：必须声明和初始化值
        int i=10;
        System.out.println(i);
        //变量类型 变量名字 =new base.Demo04();
        Demo04 demo04 = new Demo04();
        System.out.println(demo04.age);
        System.out.println(demo04.name);
        //类变量 static
        System.out.println(salary);
        System.out.println(PI);
    }
    //其他方法
    public void add(){

    }
}
