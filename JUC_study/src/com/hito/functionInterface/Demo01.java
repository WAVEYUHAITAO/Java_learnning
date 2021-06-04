package com.hito.functionInterface;

import java.util.function.Function;
/**
 * 函数式接口
 */

public class Demo01 {
    public static void main(String[] args) {
        //工具类，输入输出的值
//        Function function = new Function<String, String>() {
//
//            @Override
//            public String apply(String str) {
//                return str;
//            }
//        };
        Function<String,String> function = str-> str;

        System.out.println(function.apply("asd"));
    }
}
