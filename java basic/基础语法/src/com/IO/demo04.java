package com.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class demo04 {
    public static void main(String[] args) {
        new demo04().testFileInputStream();
        testOutputStream();
        copyFile("F:\\repositories\\Java-learning\\test\\tt5.txt","F:\\repositories\\Java-learning\\test\\tt6.txt");
        copyFile("C:\\Users\\Admin\\Desktop\\新建文件夹\\ASC2码对照表.png","F:\\repositories\\Java-learning\\test\\ASC2码对照表.png");
        //copyfile用FileInputStream可以复制任何文件，而FileReader只能对文件复制
    }
    public void testFileInputStream(){
        try {
            FileInputStream f1 = new FileInputStream("F:\\repositories\\Java-learning\\test\\tt1.txt");
            byte[] b = new byte[20];
            //f1.read(); 不加字节文件在括号会 只读一个字节！！！
            System.out.println(Arrays.toString(b));
            System.out.println(new String(b,0,f1.read(b)));
            f1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void testOutputStream(){
        try {
            FileOutputStream out = new FileOutputStream("F:\\repositories\\Java-learning\\test\\tt2.txt");
            String str = "yuhaitao";
            byte[] c = new byte[30];
            c= str.getBytes(StandardCharsets.UTF_8);
            out.write(c,1,4); //把数据写到内存中
            out.flush();//把内存中的数据刷写到硬盘
            out.close();//关闭文件输出流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String inPath , String outPath){
        try {
            FileInputStream f1 = new FileInputStream(inPath);
            FileOutputStream f2 = new FileOutputStream(outPath);

            byte[] b = new byte[100];
            int len = 0;
            while((len = f1.read(b))!=-1 ){
                System.out.println(len);
                f2.write(b,0,len);

            }
            f2.flush();
            f2.close();
            f1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
