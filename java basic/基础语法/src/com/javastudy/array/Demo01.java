package com.javastudy.array;

public class Demo01 {
    public static void main(String[] args) {
        int[] nums; //变量类型后加中括号,常用
        int nums2[]; //这种也可以，是为了早期c++程序员适应java

        nums = new int[10]; //创建了一个可以存10个int类型数字

        //给数组赋值
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;
        nums[5] = 6;
        nums[6] = 7;
        nums[7] = 8;
        nums[8] = 9;
        nums[9] = 10;
        //nums[9] = 10;   //数组的默认值是0


        //System.out.println(nums[10]); //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 10

        //计算所有元素的值
        int sum = 0;
        //获取数组的长度： arrays.length

        for(int i =0 ; i<nums.length ; i++){
            sum = sum + nums[i];
        }
        System.out.println(sum);
    }
}
