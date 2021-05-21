package com.set;

import java.util.Map;
import java.util.TreeMap;

public class demo05 {
    public static void main(String[] args) {
        Map<Integer , String> map = new TreeMap<Integer , String>();
        map.put(4 , "a");
        map.put(2 , "b");
        map.put(3 , "c");
        map.put(1 , "d");

        System.out.println(map); //按照key排序

        Map<String, String> map1 = new TreeMap<String, String>();
        map1.put("b" , "b");
        map1.put("c" , "c");
        map1.put("d" , "a");
        map1.put("a" , "d");
        map1.put("ab" , "ab");
        map1.put("1" , "ab");
        map1.put("10" , "bc");

        System.out.println(map1);
    }
}
