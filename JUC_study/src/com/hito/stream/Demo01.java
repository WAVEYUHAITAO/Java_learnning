package com.hito.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 要求：1.ID必须是偶数
 * 2.年龄必须大于23
 * 3.用户名转为大写字母
 * 4.用户字母带着排序
 * 5.只输出一个用户
 */
public class Demo01 {
    public static void main(String[] args) {
        User U1 = new User(1,"a",21);
        User U2 = new User(2,"b",22);
        User U3 = new User(3,"c",23);
        User U4 = new User(4,"d",24);
        User U5 = new User(6,"e",25);
        List<User> list = Arrays.asList(U1, U2, U3, U4, U5);

        //Stream流 ,链式编程
        list.stream()
                .filter(a-> a.getId()%2 ==0)
                .filter(a->a.getAge()>23)
                .map(a->a.getName().toUpperCase())
                .sorted((a,b)->b.compareTo(a))
                .limit(1) //限制输出为1
                .forEach(a-> System.out.println(a));

    }
}

class User{
    private int id;
    private String name;
    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
