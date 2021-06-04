package com.hito.functionInterface;

import java.util.function.Predicate;

/**
 * 断定型接口：有一个输入参数，返回值只能是 布尔值
 */
public class Demo02 {
    public static void main(String[] args) {
        Predicate predicate = new Predicate<String>() {
            @Override
            public boolean test(String str) {
                return str.isEmpty();
            }
        };
        System.out.println(predicate.test(""));
    }



}
