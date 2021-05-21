package com.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class demo06 {
    public static void main(String[] args) {
        new demo06().testFileReader("F:\\repositories\\Java-learning\\test\\tt1.txt");
        new demo06().testFileWriter("F:\\repositories\\Java-learning\\test\\tt4.txt");
        copyFile("F:\\repositories\\Java-learning\\test\\tt4.txt","F:\\repositories\\Java-learning\\test\\tt5.txt");

        //copyFile("C:\\Users\\Admin\\Desktop\\新建文件夹\\ASC2码对照表.png","F:\\repositories\\Java-learning\\test\\ASC2码对照表.png");
        //字符流复制图片会报错
    }

    /**
     * 文件字符输入流FileReader
     * @param inPath
     */
    public void testFileReader(String inPath){
        try {
            FileReader fr = new FileReader(inPath); //创建字符输入流对象
            char[] c = new char[10]; //创建临时存放数据的字符数组
            int len = 0 ;
            while ((len=fr.read(c))!=-1){
                System.out.println(new String(c,0,len));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testFileWriter(String outPath){
        try {
            FileWriter fw = new FileWriter(outPath);
            fw.write("text");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String originalPath, String destinationPath){
        try {
            FileReader fr = new FileReader(originalPath);
            FileWriter fw = new FileWriter(destinationPath);
            char[] c = new char[100];
            int len = 0;
            while ((len =fr.read(c))!=-1) {
                fw.write(c, 0, len);
                System.out.println(len);
            }
            fw.flush();
            fw.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
