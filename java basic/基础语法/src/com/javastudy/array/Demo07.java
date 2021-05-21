package com.javastudy.array;

import java.util.Arrays;

public class Demo07 {
    public static void main(String[] args) {
        int[] a ={2,4,9,5,54,768,45,34,688,98,24,54,7};
        int[] sort = sort(a);
        System.out.println(Arrays.toString(sort));

    }


    //冒泡排序
    //比较数组中两个相邻的元素，如果第一个数比第二个大，我们就交换他们的位置
    //每一轮都可以产生一个最大或者最小数字

    public static int[] sort(int[] array){
        int temp = 0;
        //外层循环，判断我们要循环多少次,这里两两比较n-1次。
        for(int i =0; i< array.length-1; i++){
            //内层循环，比较两个数，如果第一个比第二个大，则交换位置
            for(int j = 0; j < array.length-1-i; j++){
                if(array[j+1]<array[j]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1]=temp;
                }
            }

        }
        return array;
    }
}
