package com.IO;

import java.io.*;

public class demo11 {
    public static void main(String[] args) {
        try {
            testDataOutputStream();
            testDataInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 数据输出流
     * 用数据输出流写到文件中的基本数据类型的数据是乱码的 不能直接辨认出来 需要数据输入流读取
     * 用数据输入流来读取输出流写到文件中的数据时要保证使用和当时写的数据类型一致的类型来读取
     */
    public static void testDataOutputStream() throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream("F:\\repositories\\Java-learning\\java basic\\基础语法\\src\\com\\IO\\tt2.txt"));
        //out.writeBoolean(true);
        //out.writeDouble(1.35d);
        out.writeInt(100);
        out.flush();
        out.close();
    }

    public static void testDataInputStream() throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream("F:\\repositories\\Java-learning\\java basic\\基础语法\\src\\com\\IO\\tt2.txt"));
        System.out.println(in.readInt());
        in.close();
    }

}
