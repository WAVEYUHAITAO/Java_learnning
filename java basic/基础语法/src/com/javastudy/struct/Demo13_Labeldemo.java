package com.javastudy.struct;

public class Demo13_Labeldemo {
    public static void main(String[] args) {
        //打印101-150之间的质数,只能被1和本身整除
         int count = 0;
         outer:for(int i =101;i<150;i++){
             for(int j=2; j<i/2;j++){
                 if(i%j==0){
                     continue outer;
                 }
             }
             System.out.println(i+" ");

         }
    }
}
