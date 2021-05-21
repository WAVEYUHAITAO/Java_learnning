package com.javastudy.array;

public class Demo02 {
    public static void main(String[] args) {
        //静态初始化：创建+赋值
        int[] a = {1,2,3,4,5,6,7,8};
        System.out.println(a[0]);

        //动态初始化
        int[] b = new int[10];
        b[0] = 10;

        for(int i=0 ; i<=7; i++){
            System.out.println(a[i]);
        }

//        System.out.println(b[1]);  //int 数组默认值是0 , str数组默认值是Null，数组保存在堆中
//        System.out.println(b[2]);
//        System.out.println(b[3]);
//        System.out.println(b[0]);
    }
}
