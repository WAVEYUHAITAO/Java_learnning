package com.IO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class demo07 {
    public static void main(String[] args) {
        try {
            testBufferedInputStream();
            testBufferedOutputStream();
            copyFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 缓冲字节输入流
     *
     */
    public static void testBufferedInputStream() throws Exception {
        //文件字节输入流对象
        FileInputStream in = new FileInputStream("F:\\repositories\\Java-learning\\test\\tt6.txt");

        //缓冲字节输入流对象
        BufferedInputStream br = new BufferedInputStream(in);

        byte[] b = new byte[1024];

        int len = 0;

        while((len = br.read(b))!=-1){
            System.out.println(new String(b,0,len));
        }
        //关闭流的时候最后开的先关
        br.close();
        in.close();
    }

    public static void testBufferedOutputStream() throws IOException {
        //创建字节输出流对象
        FileOutputStream out = new FileOutputStream("F:\\repositories\\Java-learning\\java basic\\基础语法\\src\\com\\IO\\tt.txt");
        //把字节输出流对象放到缓冲字节输出流中
        BufferedOutputStream bo = new BufferedOutputStream(out);

        String s = "hello world";
        bo.write(s.getBytes(StandardCharsets.UTF_8));
        bo.flush(); //刷到硬盘上
        bo.flush(); //刷到硬盘上

        bo.close();
        out.close();
    }

    public static void copyFile() throws Exception {
        //缓冲输入流
        BufferedInputStream br = new BufferedInputStream(new FileInputStream("F:\\repositories\\Java-learning\\java basic\\基础语法\\src\\com\\IO\\tt1.txt"));
        //缓冲输出流
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream("F:\\repositories\\Java-learning\\java basic\\基础语法\\src\\com\\IO\\tt2.txt"));

        byte[] b = new byte[1024];

        int len =0;

        while((len = br.read(b))!=-1){
            bo.write(b,0,len); //写到内存中
            bo.flush();  //刷到硬盘里
        }
        bo.close(); //正开反关
        br.close();

    }
}
