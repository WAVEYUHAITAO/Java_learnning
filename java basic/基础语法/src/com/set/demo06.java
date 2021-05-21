package com.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class demo06 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("b");
        list.add("cd");
        list.add("ca");
        list.add("a");
        list.add("1");
        //Collections 用法
        System.out.println(list);
        Collections.reverse(list); //反转list排序
        System.out.println(list);

        Collections.shuffle(list); //随机排序
        System.out.println(list);

        Collections.sort(list); //按照字典顺序升序排列
        System.out.println(list);

        Collections.swap(list , 0 ,3); //交换位置
        System.out.println(list);

        System.out.println(Collections.max(list)); //返回最大值
        System.out.println(Collections.min(list)); //返回最小值

        System.out.println(Collections.frequency(list , "a")); //返回元素出现次数
        System.out.println(Collections.frequency(list , "x")); //返回元素出现次数

        Collections.replaceAll(list , "a" , "aa"); //使用新值替换旧值
        System.out.println(list);
        System.out.println("=================================================");


        Student s1 = new Student(14, "张三");
        Student s2 = new Student(12, "李四");
        Student s3 = new Student(15, "王五");
        Student s4 = new Student(11, "刘二");
        Student s5 = new Student();
        String s6 = new String("123");
        System.out.println(s6);
        List<Student> stus = new ArrayList<Student>();
        stus.add(s1);
        stus.add(s2);
        stus.add(s3);
        stus.add(s4);

        Student s = Collections.max(stus , new Student()); //通过collections返回最大值
        System.out.println(s.name+","+s.age);

        Student ss = Collections.min(stus , new Student());//通过collections返回最小值
        System.out.println(ss.name+","+ss.age);


        System.out.println(stus);
        for(Student x : stus){
            System.out.println(x.age+" "+x.name);
        }
        System.out.println("===========================");
        Collections.sort(stus , new Student());  //加入了自定义comparator new Student(); 也是调用sort方法的重载
        for(Student xx : stus){
            System.out.println(xx.age+" "+xx.name);
        }
    }
}


class Student implements Comparator<Student>{
    int age;
    String name;
    public Student(){

    }

    public Student(int age , String name){
        this.age = age;
        this.name = name;
    }
    @Override
    public int compare(Student o1, Student o2) { //根据年龄升序排列
        if(o1.age > o2.age){
            return 1;
        }else if(o1.age < o2.age){
            return -1;
        }else{
            return 0;
        }
    }
}
