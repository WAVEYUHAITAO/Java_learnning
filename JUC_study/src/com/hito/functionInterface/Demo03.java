package com.hito.functionInterface;

import java.util.function.Consumer;

/**
 * Consumer 消费型接口 只要输入没有返回值
 */
public class Demo03 {
    public static void main(String[] args) {
//        Consumer consumer = new Consumer<String>() {
//            @Override
//            public void accept(String str) {
//                System.out.println(str);
//            }
//        };
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("djk");
    }
}
