package com.set;


import java.util.ArrayList;
import java.util.List;

public class demo03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList();

        list.add("d");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("a"); //允许重复元素
        list.add("a");


        System.out.println(list.get(2));  //List通过索引来访问指定位置的元素

        for(Object a : list){
            System.out.print(a+" ");
        }
        System.out.println();
        list.add(1,"f"); //在指定索引下标位置插入元素
        System.out.println(list);


        List<String> l = new ArrayList<String>();
        l.add("123");
        l.add("456");

        list.addAll(2,l); //在指定位置插入集合
        System.out.println(list);

        System.out.println(list.indexOf("d")); //获取指定元素第一次出现的位置
        System.out.println(list.lastIndexOf("d")); //获取指定元素第一次出现的位置

        list.set(1,"ff");
        System.out.println(list);

        List sublist = list.subList(2,4);
        System.out.println(sublist); //根据下标起始位置截取元素，形成新的集合，不包括最后一个位置

        System.out.println(list.size()); //list长度
    }
}
