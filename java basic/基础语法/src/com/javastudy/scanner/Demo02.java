package com.javastudy.scanner;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        //创建一个扫描器对象，用于接收键盘输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("使用nextLine方式接收:");

        //判断用户是否还有输入
        if(scanner.hasNextLine()){
            String str = scanner.nextLine(); //nextLine得到的是回车键以前的
            System.out.println("输入的内容为:"+str);
        }
        scanner.close();

    }
}
