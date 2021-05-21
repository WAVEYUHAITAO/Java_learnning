package com.IO;

import java.io.*;

/**
 * 缓冲字符流
 *
 */
public class demo08 {
    public static void main(String[] args) {
        try {
            //testBufferedReader();
            testBufferedWriter();
            //copyFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 缓冲字符输入流
     */
    public static void testBufferedReader() throws Exception {
        FileReader r = new FileReader("F:\\repositories\\Java-learning\\java basic\\基础语法\\src\\com\\IO\\tt.txt");

        BufferedReader br = new BufferedReader(r);

        char[] c = new char[100];

        int len = 0;

        while((len = br.read(c))!=-1){
            System.out.println(new String(c,0,len));
            System.out.println(len);
        }
        br.close();
        r.close();
    }
    /**
     * 缓冲字符输出流
     */
    public static void testBufferedWriter() throws IOException {
        FileWriter w = new FileWriter("F:\\repositories\\Java-learning\\java basic\\基础语法\\src\\com\\IO\\tt2.txt");
        BufferedWriter bw = new BufferedWriter(w);

        String s = "!!!!!!!!!!";
        bw.write(s);

        bw.flush();
        bw.close();
        w.close();
    }

    /**
     * 缓冲字符流复制文件
     */
    public static void copyFile() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("F:\\repositories\\Java-learning\\java basic\\基础语法\\src\\com\\IO\\tt.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\repositories\\Java-learning\\java basic\\基础语法\\src\\com\\IO\\tt2.txt"));
        int len = 0;
        char[] c = new char[1024];
        while((len = br.read(c))!=-1){
            bw.write(c,0,len);
            System.out.println(len);
        }
        bw.flush();
        bw.close();
        br.close();
    }


}
