package com.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class demo03 {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("F:\\repositories\\Java-learning\\test\\tt1.txt");
            byte[] b = new byte[10];//设置一个byte数组接收读取的文件内容, 返回的是ASCII码的十进制数组
            //System.out.println(in.read(b)); //in.read(b)把文件内容写进b里，最多按照b的大小写入，会返回一个int到底写了多少个
            //如果读取到最后一个数据，还会向后读取一个，返回值就是-1，意味着文件读取完了，
            //在一个文件访问流里读两次in.read(b)，因为第一次已经读完，返回值为字节数组长度，第二次为-1
            int len = 0;
//            while((len = in.read(b))!=-1){
//                System.out.println(new String(b,0,len));
//            }
            System.out.println(new String(b,0,in.read(b)));

            System.out.println(Arrays.toString(b)); //这个返回一个带括号的string 十进制 数组
            System.out.println(b);

            for(byte b1 : b){
                System.out.println(b1);
            }
            System.out.println(in.read(b));
            in.close(); //流在使用完要关闭


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
