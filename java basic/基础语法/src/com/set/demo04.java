package com.set;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class demo04 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("b",1);
        map.put("c",3);
        map.put("a",1);
        map.put("d",4);
        System.out.println(map);

        System.out.println(map.get("c")); //根据key取值

        map.remove("c"); //根据key移除
        System.out.println(map);

        System.out.println(map.size());

        System.out.println(map.containsKey("b"));
        System.out.println(map.containsKey("c")); //判断知否包含指定key

        System.out.println(map.containsValue(1));
        System.out.println(map.containsValue(10));//判断当前集合有没有这个value

        //遍历集合

        map.keySet(); //获取所有的key的集合

        map.values(); //获取所有value

        Set keys = map.keySet();
        //增强for循环遍历
        for(String key : map.keySet()){
            System.out.println("key: "+key+", value: "+map.get(key));
        }
        //通过map.entrySet()遍历
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for(Map.Entry<String, Integer> en: entries ){
            System.out.println("key: "+en.getKey()+", value: "+en.getValue());

        }

        map.clear();//清空集合
        System.out.println(map);


    }
}
