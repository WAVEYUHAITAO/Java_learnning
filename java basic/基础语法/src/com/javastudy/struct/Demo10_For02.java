package com.javastudy.struct;

public class Demo10_For02 {
    public static void main(String[] args) {
        //练习：计算0-100之间的奇数和偶数的和

        int oddSum = 0;
        int evenSum= 0;
        for (int i = 0; i <= 100; i++) {
            if(i%2!=0){
                oddSum+=i;
            }else{
                evenSum+=i;
            }

        }
        System.out.println("1-100奇数和："+oddSum);
        System.out.println("1-100偶数和："+evenSum);
    }
}
