package com.IO;

import java.io.*;

/**
 * 标准输入和输出流
 */

public class demo10 {
    public static void main(String[] args) {
        try {
            //testSystemIn();
            write2Txt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 标准的输入流
     * @throws IOException
     */
    public static void testSystemIn() throws IOException {
        //创建一个接收键盘输入数据的输入流
        InputStreamReader is = new InputStreamReader(System.in);

        //把输入流放到缓冲流里
        BufferedReader br = new BufferedReader(is);

        String str = ""; //定义一个临时接收数据的字符串

        while ((str = br.readLine())!=null){
            System.out.println(str);
        }
        br.close();
        is.close();
    }


    public static void write2Txt() throws IOException {
        //创建一个接收键盘输入数据的输入流
        InputStreamReader is = new InputStreamReader(System.in);
        //把输入流放到缓冲流里
        BufferedReader br = new BufferedReader(is);

        BufferedWriter out = new BufferedWriter(new FileWriter("F:\\repositories\\Java-learning\\java basic\\out\\production\\基础语法\\com\\IO\\tt3.txt"));
        String line = "";
        while ((line=br.readLine())!=null){
            if(line.equals("结束")){
                break;
            }
            out.write(line+"\n"); //换行方法2

            //out.newLine(); //换行方法1
        }
        out.flush();
        out.close();
        br.close();
        is.close();
    }
}
