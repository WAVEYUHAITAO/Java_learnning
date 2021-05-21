package com.javastudy.struct;

public class Demo11_For03 {
    public static void main(String[] args) {
        //用while或者for输出1-1000能被5整除的数，并且每行输出3个
        for (int i = 0; i <= 1000; i++) {
            if(i%5==0){
                System.out.print(i+"\t"); //print()输出后不换行
            }
            if(i%(5*3)==0){
                System.out.println();  //println()输出后会换行
            }

        }
    }
}
