package com.javastudy.scanner;

import java.util.Scanner;

public class Demo04 {
    public static void main(String[] args) {
        //求总和和平均数，每输入一个数字用回车确认，通过输入非数字来结束输入并输出执行结果
        Scanner scanner = new Scanner(System.in);

        //和
        double sum = 0;
        //计算输入了多少个数字
        int m = 0;

        //通过循环判断是否还有输入，并在里面对每一次进行求和和统计
        while(scanner.hasNextDouble()){
            double v = scanner.nextDouble();
            m=m+1;//m++

            sum=sum +v;
            System.out.println("你输入了第"+m+"个数据，当前和结果sum="+sum);

        }
        System.out.println(m+"个数的和为:"+sum);
        System.out.println(m+"个数的平均数为:"+sum/m);

        scanner.close();
    }

}
