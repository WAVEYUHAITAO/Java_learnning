package com.hito.single;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//enum 是一个什么？ 本身也是一个Class类
public enum EnumSingle {
    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;

    }
}

class Test{
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        EnumSingle instance1 = EnumSingle.INSTANCE;
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);//如果里面放null会报我们不想要的错.NoSuchMethodException: com.hito.single.EnumSingle.
        // 通过jad反编译能看到枚举类的构造不是空参，加入参数后就返回代码里的error ： IllegalArgumentException: Cannot reflectively create enum objects
        declaredConstructor.setAccessible(true);
        EnumSingle instance2 = declaredConstructor.newInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}
