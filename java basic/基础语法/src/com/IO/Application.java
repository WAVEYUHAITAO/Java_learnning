package com.IO;

import java.io.*;
//序列化与反序列化
public class Application {
    public static void main(String[] args) {
        try {
           // testSerialize();
            testDeserialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对象的序列化
     */
    public static void testSerialize() throws Exception {
        //定义对象的输出流，把对象的序列化之后的流放到指定的文件里
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("F:\\repositories\\Java-learning\\java basic\\out\\production\\基础语法\\com\\IO\\tt4.txt"));
        demo12 d12 = new demo12();
        d12.name="傻子0";
        d12.age=13;

        out.writeObject(d12);
        out.flush();
        out.close();
    }

    public static void testDeserialize() throws Exception {
        //创建对象输入流对象，从指定文件中把对象序列化后的流读取出来

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("F:\\repositories\\Java-learning\\java basic\\out\\production\\基础语法\\com\\IO\\tt4.txt"));

        Object obj = in.readObject();
        demo12 d12 = (demo12) obj;
        System.out.println(d12.name);
        System.out.println(d12.age);
    }
}
