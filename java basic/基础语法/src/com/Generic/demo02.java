package com.Generic;

public class demo02 {
    public static void main(String[] args) {
        B1<Object> b1 = new B1<Object>(); //未传入实参的泛型类需要指定数据类型
        B1<String> b2 = new B1<String>();

        B2 b3 = new B2();//传入数据类型的实现类不需要指定类型
        Cc<Object> cc = new Cc<Object>(); //调用泛型类
        System.out.println(cc.test1("我爱你"));
        System.out.println(cc.test1(123));

        cc.test("xxx");
        Integer i = cc.test1(2);
        System.out.println(i);
        Boolean b = cc.test1(true);
        System.out.println(b);
    }
}

interface IB<T>{
    T test(T t);
}
//未传入泛型实参时，与泛型类的定义相同，在声明类的时候，也需要将泛型的声明一起加入
class B1<T> implements IB<T>{

    @Override
    public T test(T t) {
        return t;
    }
}
//泛型类传入实参了，就不用再声明类的时候加上泛型的声明
class B2 implements IB<String>{

    @Override
    public String test(String s) {
        return null;
    }
}


class Cc<E>{

    private E e;

    public static <T> void test3(T t){ //静态方法的泛型方法
      //  System.out.println(this.e);
        System.out.println(t);
    }



    public <T> void test(T s){  //无返回值的泛型方法
        //在类上定义的泛型可以再普通方法中调用
        System.out.println(this.e);
        T t = s;
        System.out.println(t);
    }

    public <T> T test1(T s){ //有返回值的泛型方法
        return s;
    }
    public<T> void test2(T...strs){  //可变参数，在类型后加...代表strs可以是一个集合。
        for(T s : strs){
            System.out.println(s);
        }
    }
}
