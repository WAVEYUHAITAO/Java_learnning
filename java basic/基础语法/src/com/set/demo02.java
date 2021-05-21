package com.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Set;

public class demo02 {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<Integer>();
        //TreeSet自然排序
        set.add(5);
        set.add(2);
        set.add(4);
        set.add(3);
        System.out.println(set);

        set.remove(5);
        boolean a = set.contains(4);
        System.out.println(a);
        System.out.println(set);

        //迭代器遍历集合
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //加强for循环

        for(Integer i : set){
            System.out.println(i);
        }

        Person p1 = new Person("张三",23);
        Person p2 = new Person("李四",19);
        Person p3 = new Person("王五",18);
        Person p4 = new Person("lucy",24);

        Set<Person> set1 = new TreeSet<Person>(new Person());
        //这里new person()是TreeSet的方法重载,传入了一个自定义的comparator
        //如果不传参数,则TreeSet()将自然排序（sorted according to the natural ordering of its elements）
        set1.add(p1);
        set1.add(p2);
        set1.add(p3);
        set1.add(p4);

        for(Person i : set1){
            System.out.println(i.name+" "+i.age);
        }
    }
}

class Person implements Comparator<Person>{ //把person对象存到TreeSet中并按照年龄排序,需要调用Comparator接口
    int age;
    String name;
    public Person(){

    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compare(Person o1, Person o2) {    //这里决定了排序方式是升序还是降序
        if(o1.age > o2.age){
            return 1;
        }else if(o1.age < o2.age){
            return -1;
        }else{
            return 0;
        }
    }
}
