package com.javastudy.struct;

public class Demo08_dowhile01 {
    public static void main(String[] args) {
        int i = 0;
        int sum = 0;
        //while和do-while的区别:
        //while先判断再执行，dowhile是先执行后判断！
        //Do...while总是保证循环体会被至少执行一次
        do{
            sum = sum +i;
            i++;
        }while (i<=100);
        System.out.println(sum);
    }
}
