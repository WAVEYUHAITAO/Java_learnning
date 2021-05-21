package com.IO;

import java.io.File;

public class demo02 {
    //遍历java-learning文件夹，不论层级有多深，全部遍历出来
    //使用递归的方式来实现
    public static void main(String[] args) {
        File f1 = new File("F:\\repositories\\Java-learning\\test");
        new demo02().goThrough(f1);
        System.out.println("================================================================");
        File f2 = new File("F:\\repositories\\Java-learning\\java basic");
        new demo02().goThrough(f2);

    }

    public void goThrough(File f){
        if(f.isFile()){
            System.out.println(f.getAbsolutePath()+"是文件");
        }else{
            System.out.println(f.getAbsolutePath()+"是文件夹");
            //如果是文件夹，就有子文件或者文件夹
            File[] fs = f.listFiles(); //获取当前目录下子文件夹或者文件的File对象
            if(fs != null && fs.length>0){
                for(File ff : fs){
                    goThrough(ff); //递归
                }

            }

        }
    }


}

