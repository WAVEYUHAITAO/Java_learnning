package com.IO;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.File;
import java.io.IOException;

public class demo01 {
    public static void main(String[] args) {
        File f = new File("F:\\repositories\\Java-learning\\test\\tt.txt"); //注意需要转义斜杠
        File f3 = new File("F:\\repositories\\Java-learning\\test");
        //File f = new File("F:/repositories/Java-learning/test/tt.txt");
        File f1 = new File("F:\\repositories\\Java-learning","test\\tt.txt");//与f相同，这种用的很少

        //注意，\在文件中是路径的分隔符，但是在java编程中一个\的意思是转义符，在java中\\或者/才是文件的分隔符
        //也可以用 File.separator作为分隔符

        System.out.println(f.getName()); //获取文件名
        System.out.println(f3.getName());//获取当前文件夹目录名称

        File f5 = new File("基础语法/src/com/IO/demo01.java"); //使用相对路径来创建file对象


        System.out.println(f5.getPath()); //获取文件夹路径
        System.out.println(f5.getParent()); //获取文件父级路径
        System.out.println(f5.getAbsolutePath()); //获取绝对路径

        System.out.println(f5);
        System.out.println(f5.getAbsoluteFile());//返回一个用当前的文件的绝对路径构建的file对象

        f.renameTo(new File("F:\\repositories\\Java-learning\\test\\tt1.txt")); //给文件或者文件夹重命名


        File f6 = new File("F:\\repositories\\Java-learning\\test\\tt1.txt");
        System.out.println(f6.exists()); //判断文件或者文件夹是否存在
        System.out.println(f1.exists());

        System.out.println(f6.canWrite()); //判断文件是否可以可写
        System.out.println(f6.canRead()); //判断文件是否可以可读

        System.out.println(f6.isFile()); //判断当前File对象是不是文件
        System.out.println(f6.isDirectory()); //判断当前File对象是不是文件夹

        System.out.println(f6.lastModified()); //获取文件最后修改时间，返回的是一个毫秒数
        System.out.println(f6.length()); //返回文件的长度，单位是字节数

        File f8 = new File("F:\\repositories\\Java-learning\\test\\tt2.txt");
        System.out.println(f8.exists()); //判断文件是否存在
        if(!f8.exists()){
            try {
                f8.createNewFile(); //创建一个新文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        f8.delete(); //删除文件

        File f9 = new File("F:\\repositories\\Java-learning\\test\\cc");
        f9.mkdir(); //创建单层目录，如果要创建多层目录，就要一层一层的执行

        File f10 = new File("F:\\repositories\\Java-learning\\test\\cc\\dd\\ee");
        f10.mkdirs();//创建多层目录

        File f11 = new File("F:\\repositories\\Java-learning\\test");
        System.out.println(f11.list()); //返回的是当前文件夹的栈内存索引

        String[] f111 = f11.list();
        for(String s : f111){
            System.out.println(s);   //输出当前文件夹的子集的名称，包括目录和文件
        }
        System.out.println("=============================");

        File[] f112 = f11.listFiles(); //输出当前文件夹的子集的File对象，包括目录和文件
        for(File ff : f112){
            System.out.println(ff);
        }
    }
}
