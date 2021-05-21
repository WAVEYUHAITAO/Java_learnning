package com.javastudy.array;

import java.util.Arrays;
public class Demo06 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,8,54,34,6,13};
        System.out.println(a);//打印出a的哈希

        //打印数组元素Arrays.toString
        System.out.println(Arrays.toString(a));

        printArray(a);

        Arrays.sort(a); //数组排序
        System.out.println(Arrays.toString(a));
        Arrays.fill(a,2,4,888);
        System.out.println(Arrays.toString(a));

    }

    public static void printArray(int[] a){
        for(int i = 0; i<a.length; i++ ){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
