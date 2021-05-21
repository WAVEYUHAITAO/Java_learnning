package com.reflection;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        demo01 demo01 = new demo01();
        Class c = demo01.getClass(); //c对象中就包含了demo01类的所有的信息


        //通过类名创建class对象
        Class c0 = com.reflection.demo01.class;
        //通过实例去创建,通过一个实例对象的getclass()方法
        Class c1 = demo01.getClass();

        try {
            //通过Class的静态方法forName(String className)来获取一个类的Class实例
            //forName方法的参数是你要获取的Class实例的类的全路径（包名，类名）
            Class c2 = Class.forName("com.reflection.demo01"); //这个是获取class实例的常用方法
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Class clazz = Class.forName("com.reflection.Student");

            //利用反射机制调用指定公有方法
            Constructor cn = clazz.getConstructor();//获取无参构造
            Object obj1 = cn.newInstance();//使用无参构造创建(实例化)对象
            //调用指定公有属性
            Student stu3 = (Student)obj1;
            Field fff = clazz.getField("school");
            fff.set(stu3,"第三中学");
            String school =(String) fff.get(stu3);
            System.out.println(school);
            //调用指定私有属性
            Field fff1 = clazz.getDeclaredField("privateField");
            fff1.setAccessible(true); //解除封装
            fff1.set(obj1,"第四中学");
            System.out.println(fff1.get(obj1));
            //===================
            Method m = clazz.getMethod("setInfo", String.class, String.class);//得到名称叫setInfo的方法
            m.invoke(obj1,"zhangsan","第一中学");//参数1是需要实例化的对象，后面的参数是调用当前的方法的实际参数
            //利用反射机制调用指定私有方法
            Method m2 = clazz.getDeclaredMethod("test",String.class);
            m2.setAccessible(true);
            m2.invoke(obj1,"李四");

            Field[] fs = clazz.getFields(); //获取公有属性,包含父类的公有属性
            Field[] fs1 = clazz.getDeclaredFields(); //获取本类（不包括父类的属性）所有属性,包括私有属性
            for(Field f : fs1){
                System.out.println("修饰符："+f.getModifiers());
                System.out.println("属性类型："+f.getType());
                System.out.println("属性名称："+f.getName());

            }
            System.out.println("==============================================");
            Package p = clazz.getPackage(); //获取类所在的包
            System.out.println(p.getName());

            Object obj = clazz.newInstance();// 调用Student类的无参公有的构造方法
            Student stu = (Student)obj;

            //Method[] ms = clazz.getMethods(); //获取到类的所有公有的方法
            Method[] ms = clazz.getDeclaredMethods(); //获取类的所有方法，包括公有和私有
            for(Method m1: ms){
                System.out.println("方法名"+m1.getName());
                System.out.println("返回值类型"+m1.getReturnType());
                System.out.println("修饰符"+m1.getModifiers());
                Class[] pcs = m1.getParameterTypes();
                for(Class pc : pcs){
                    System.out.println("参数类型"+pc.getName());
                }
            }
            System.out.println("=====================================================");

            Constructor ct = clazz.getConstructor(String.class); //指定获取有一个参数的构造函数
            Student stu1 =(Student)ct.newInstance("第一中学");
            System.out.println(stu1.school);
            Class superClass = clazz.getSuperclass();

            //通过反射机制 强制调用私有的构造方法
            Constructor cr = clazz.getDeclaredConstructor(String.class,int.class);
            cr.setAccessible(true);//解除私有的封装，下面就可以对这个私有方法强制调用
            Student stu2 = (Student)cr.newInstance("张燕",12);


            Class[] interfaces = clazz.getInterfaces();//获取当前类的所有接口
            for(Class cc :interfaces){
                System.out.println("接口："+cc.getName());
            }
            System.out.println(superClass.getName());

            Constructor[] cons = clazz.getConstructors();//获取到类的公有的构造方法
            for(Constructor cc : cons){
                System.out.println("=============================================");
                //cc.getModifiers() 取得修饰符，返回1代表public ，2代表private， 4代表protected
                System.out.println("构造方法名字："+cc.getName()+"的修饰符是"+cc.getModifiers());

                Class[] para = cc.getParameterTypes();
                for(Class pc : para){
                    System.out.println("构造方法"+cc.getName()+"参数类型是："+pc.getName());
                }
                System.out.println("=============================================");
            }


            Constructor[] cons1 = clazz.getDeclaredConstructors();//获取类的所有构造方法,包括公有和私有
            for(Constructor cd : cons1){
                System.out.println("==============================================");
                System.out.println("构造方法名字："+cd.getName()+"的修饰符是"+cd.getModifiers());

                Class[] para = cd.getParameterTypes();
                for(Class pc : para){
                    System.out.println("构造方法"+cd.getName()+"参数类型是："+pc.getName());
                }
                System.out.println("=================================================");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
}
