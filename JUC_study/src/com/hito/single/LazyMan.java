package com.hito.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

//懒汉式单例
public class LazyMan {
    private static boolean hito = false;
    private LazyMan(){
        synchronized (LazyMan.class){ //这里是构造加锁,判断当前对象是否被创建,防止有人使用反射,得到构造函器创建实例,如果这里没有限创建对象还是可以用反射得到对象

            if(hito == false){
                hito = true;
            }else {
                throw new RuntimeException("不要试图使用反射破坏单例");
            }
        }
        System.out.println(Thread.currentThread().getName()+"ok");
    }
    private volatile static LazyMan lazyMan;

    public static LazyMan getInstance(){
        //加锁, 双重检测锁模式的懒汉式  简称DCL懒汉式
        if(lazyMan==null){
            synchronized (LazyMan.class){
                if(lazyMan==null){
                    lazyMan = new LazyMan(); //不是一个原子性操作
                    /**
                     * 1.分配内存空间
                     * 2.执行构造方法，初始化对象
                     * 3.把这个对象指向这个空间
                     *
                     * 有时候cpu运行不是按照123有可能是132
                     * 假设A线程执行132，分配空间并指向这个空间
                     * 这时B线程也执行的时候以为这个空间已经分配对象，lazyman!=null，直接return lazyman
                     * 这时可能会创造出空的lazyman对象
                     * 所以为了避免这种现象，必须在定义lazyMan的时候加上volatile关键字避免指令重排
                     */
                }
            }
        }

        return lazyMan;
    }
    //单线程下单例ok
    //多线程并发

    //反射！
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->LazyMan.getInstance()).start();
//        }

        //LazyMan instance = LazyMan.getInstance();


        Field hito = LazyMan.class.getDeclaredField("hito");//获得类的私有字段
        hito.setAccessible(true);//将私有字段获取属性设置为true
        //得到LazyMan的构造器
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        //设置构造器可访问，无视私有构造器
        declaredConstructor.setAccessible(true);
        LazyMan instance1 = declaredConstructor.newInstance();
        hito.set(instance1,false);//通过反射第一次hito的值变为true，这里把hito再次变为false，所以第二次反射得到的实例可以成功
        LazyMan instance2 = declaredConstructor.newInstance();

        System.out.println(instance1.hashCode());//通过内部方法得到实例
        System.out.println(instance2.hashCode());//通过反射得到的实例,这里看到两个实例哈希code不一样是两个实例，破坏了单例模式

    }



}
