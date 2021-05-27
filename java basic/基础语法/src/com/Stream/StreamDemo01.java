package com.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo01 {
    public static void main(String[] args) {
        //List<String> players = Arrays.asList("kobe","james","curry","caoMing");

        String[] players = {"kobe","james","curry","caoMing"};//数组和集合都可以


//        for(String player : players){
//            if(player.startsWith("L")){
//                String temp = player.toUpperCase();
//            }
//        }
        //用stream代替for循环
        //List<String> sorted = players.stream()
        List<String> sorted = Stream.of(players) //数组的用法
                .filter(s->s.startsWith("c"))
                .map(String::toUpperCase) //::这个是调永String里的函数
                .sorted() //括号里可以写排序规则
                .collect(Collectors.toList());
        System.out.println(sorted);
    }


}
