package com.Generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class demo01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(111);
        list.add("sss");
        list.add("true");

        //需求，只能在集合中存字符串
        //java中的泛型，只在编译阶段有效，在编译过程中检查泛型结果后，会将泛型相关信息擦除
        //并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。
        //也就是说，泛型信息不会进入到运行阶段
        List<String> l = new ArrayList<String>();
        l.add("s");
        //l.add(1); 报错


        A<String> a1 = new A<String>(); //new A的对象指定泛型类型String
        a1.setKey("xxx"); //指定传入类型
        String s = a1.getKey(); //指定返回类型


        A a2 = new A(); //不指定类型，相当于指定了一个Object类型
        a2.setKey("2");
        Object key = a2.getKey();
    }
}
//泛型类。。。
class A<T>{     //此处泛型T可以任意取名 A,B,C,D.. 最好用大写代表类的类型T
    private T key;

    public void setKey(T key){//指定传入类型
        this.key = key;
    }

    public T getKey(){//指定返回类型
        return this.key;
    }

}
