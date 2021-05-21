package com.oop.demo05;
//学生也是人，派生类，子类
//子类继承了父类，就会拥有父类的全部方法
public class Student extends Person{
    //ctrl+H

    public Student() {
        //隐藏代码，调用了父类的无参构造
        //super(); super 如果显示必须放在代码的第一行
        //如果父类只有有参构造没有无参构造且子类还想用无参
        //那么只加上super(参数);
        //this  super
        System.out.println("student无参构造执行了");
    }

    private String name = "hito";

    public void test(String name){
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);
    }
}
