package com.javastudy.struct;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        //考试大于60及格，小于60不及格
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入成绩：");
        int score = scanner.nextInt();
        if(score>60){
            System.out.println("及格");
        }else{
            System.out.println("不及格");
        }
        String str = score>60?"及格":"不及格"; //三元运算符
        System.out.println(str);


        scanner.close();
    }
}
