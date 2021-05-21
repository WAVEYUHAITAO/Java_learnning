package com.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class demo01 {
    public static void main(String[] args) {
       Set set = new HashSet();
       //Set<String> set = new HashSet<String>(); 添加了string泛型，只能添加string类型数据
       //如果想添加任意类型的数据可以定义Object类型的泛型
       set.add(1);//添加元素
       set.add("a");

        System.out.println(set);

        set.remove(1);//移除元素

        System.out.println(set);

        System.out.println(set.contains(1)); //判断是否包含元素

        set.clear();//清空集合

        System.out.println(set);

        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");

        set.add("d"); //set集合是存不进去重复的值

        set.add(null); //可以存null， null在第一位，所以HashSet不能保证顺序，只会按照哈希值排序

        System.out.println(set);

        //1.遍历这个集合，使用迭代器
        Iterator it = set.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

        //2.for each 迭代集合
        for(Object object : set){  //这边就是增强for循环
            System.out.println(object);
        }

        //集合的大小怎么看,获取元素个数
        System.out.println(set.size());
    }
}

