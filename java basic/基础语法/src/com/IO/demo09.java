package com.IO;

import java.io.*;

public class demo09 {
    public static void main(String[] args) {
        //所有的文件都是有编码格式
        //对于我们来说， txt和java文件一般来讲有三种编码
        //iso08859-1 西欧编码，是纯粹的英文编码，不适应文字
        //GBK和UTF-8,这两个编码是适用于中文和英文
        //我们一般使用utf-8编码

        try {
            testInputStreamReader();
            //testOutputStreamWriter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 转换输入流, 字节流转字符流
     * @throws Exception
     */
    public static void testInputStreamReader() throws Exception {
        FileInputStream fs = new FileInputStream("F:\\repositories\\Java-learning\\java basic\\基础语法\\src\\com\\IO\\tt2.txt");

        //把字节流转换为字符流
        InputStreamReader in = new InputStreamReader(fs,"GBK"); //参数1是字节流，参数二是编码

        char[] c = new char[100];

        int len = 0;

        while((len=in.read(c))!=-1){
            System.out.println(new String(c,0,len));
        }

        in.close();
        fs.close();
    }

    /**
     * 转换字节输出流为字符输出流
     */

    public static void testOutputStreamWriter() throws Exception {
        FileOutputStream out = new FileOutputStream("F:\\repositories\\Java-learning\\java basic\\基础语法\\src\\com\\IO\\tt2.txt");

        OutputStreamWriter os = new OutputStreamWriter(out, "UTF-8");

        os.write("你好123");
        os.flush();

        os.close();
        out.close();
    }
}
