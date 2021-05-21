package com.javastudy.array;

public class Demo05 {
    public static void main(String[] args) {
        //多维数组，以下举例2维
        //[4][2]
        /*
            1,2  array[0]
            2,3  array[1]
            3,4  array[2]
            4,5  array[3]
            5,6  array[4]
         */
        int[][] array = {{1,2},{2,3},{3,4},{4,5},{5,6}};

        System.out.println(array[0]); //打印出来hashcode
        System.out.println(array[0][0]);
        System.out.println(array[0][1]);
        System.out.println(array.length);
        System.out.println(array[0].length);
        printArray(array[0]);

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j< array[0].length; j++){
                System.out.println(array[i][j]);
            }
        }

    }
    //打印数组元素
    public static void printArray(int[] arrays) {
        for (int x : arrays) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
