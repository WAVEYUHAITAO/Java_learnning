package com.IO;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * 文件随机读写
 */
public class demo13 {
    public static void main(String[] args) {
        try {
            //testRandomAccessFileRead();
            testRandomAccessFileWrite();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 随机读文件
     */
    public static void testRandomAccessFileRead() throws Exception {
        //参数1是路径，参数2是访问模式
        //r   rw  rwd  rws
        RandomAccessFile ra = new RandomAccessFile("F:\\repositories\\Java-learning\\java basic\\out\\production\\基础语法\\com\\IO\\tt1.txt","r");

        ra.seek(0);//设置读取文件的起始点

        byte[] b = new byte[1024];

        int len = 0;
        while ((len = ra.read(b))!=-1){
            System.out.println(new String(b,2,len));
        }
    }
    public static void testRandomAccessFileWrite() throws Exception {
        //参数1是路径，参数2是访问模式
        //r   rw  rwd  rws
        RandomAccessFile ra = new RandomAccessFile("F:\\repositories\\Java-learning\\java basic\\out\\production\\基础语法\\com\\IO\\tt1.txt", "rw");
        ra.seek(0); //设置写的起始点
        //ra.seek(ra.length()); //代表从文件的结尾写
        //如果从开头或者中间写的话，会替换掉原来等长度的内容
        ra.write("你好".getBytes(StandardCharsets.UTF_8));
        ra.close();


    }

}
