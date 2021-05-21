package com.oop.demo07;


public class Application {
    public static void main(String[] args) {
        Object object = new Student();
        //Object > String
        //Object > Person >Teacher
        //Object > Person >Student

        //System.out.println(x instanceof y); 能不能通过看有没有父子关系
        System.out.println(object instanceof Student);
        System.out.println(object instanceof Person);
        System.out.println(object instanceof Object);
        System.out.println(object instanceof Teacher);
        System.out.println(object instanceof String);
        System.out.println("============================");

        Person person = new Student();
        System.out.println(person instanceof Student);
        System.out.println(person instanceof Person);
        System.out.println(person instanceof Object);
        System.out.println(person instanceof Teacher);
        //System.out.println(person instanceof String); String 和person同级
        System.out.println("============================");

        //高                   低
        Person student = new Student();
        //高转低 需要强转
        Student student1 = (Student) student;
        student1.go();

        Student student2 = new Student();
        Person s2 = student2;
        ((Student)s2).go();//子类型转父类型会丢失方法，需要强转

    }
}
