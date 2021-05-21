package com.javastudy.base;

public class Demo03 {
    public static void main(String[] args) {
        int i =128;
        byte d = (byte)i; //内存溢出
        //低--------------------------->高
        //byte,short,char-->int-->long-->float-->double
        //运算中，不同类型数据先转化为同一类型，然后进行运算
        //强制转换 （类型）变量名 高到低
        //自动转换  低到高
        System.out.println(i);
        System.out.println(d); //Byte 是从-128到127

        System.out.println("=============================");
        System.out.println((int)23.7); //23
        System.out.println((int)-45.89f); //45

        System.out.println("=============================");
        char c = 'a';
        int e = c+1;
        System.out.println(e);
        System.out.println((char)e);

        int money =10_0000_0000;
        int years =20;
        int total = money*years; //-1474836480,计算的时候就溢出了
        long total2 = money*(long)years; //这里先强转了years，然后乘法钱转换为同一类型
        System.out.println(total);
        System.out.println(total2);

    }
}
