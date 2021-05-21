package com.javastudy.scanner;
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        //创建一个扫描器对象，用于接收键盘数据
        Scanner scanner = new Scanner(System.in);
        System.out.println("使用next方式接收：");

        //判断用户有没有输入字符串
        if(scanner.hasNext()){
            //使用next方式接收
            String str = scanner.next(); //next返回的是空格前的内容
            System.out.println("输入的内容为："+str);
        }
        //凡是属于io流的如果不关闭会一直占用资源
        scanner.close();

    }
}
