package com.javastudy.base;

public class Demo02 {
    public static void main(String[] args) {
        //整数拓展：进制  二进制0b 十进制 八进制0 十六进制0x
        int i = 10;
        int i2 = 010; //八进制0
        int i3 = 0x10; //十六进制0x    0~9 A~F 16
        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println("==================================================================");
        //==================================================================
        //浮点数拓展   银行业务怎么表示？ 钱
        //BigDecimal 数学工具类
        //==================================================================
        //float 有限 离散  舍入误差  大约 接近但不等于
        //double
        //最好完全避免使用浮点数进行比较
        float f = 0.1f; //0.1
        double d = 1.0/10; //0.1

        System.out.println(f==d); //false

        float d1 = 2313131313131313131313131313f;
        float d2 = d1+1;

        System.out.println(d1==d2); //true

        //==================================================================
        //字符拓展？
        //==================================================================
        System.out.println("==================================================================");
        char c1 = 'a';
        char c2 = '中';
        System.out.println(c1);
        System.out.println((int)c1); //强制转换
        System.out.println(c2);
        System.out.println((int)c2); //强制转换
        //所有的字符本质还是数字
        //编码 Unicode 2字节 65536

        char c3 ='\u0061';
        System.out.println(c3); //a


        //转义字符
        //  \t
        //  \n
        System.out.println("Hello\tWorld");
        System.out.println("Hello\nWorld");

        System.out.println("==============================================");
        String sa = new String("hello world");
        String sb = new String("hello world");
        System.out.println(sa==sb);

        String sc = "hello world";
        String sd = "hello world";
        System.out.println(sc==sd);


        //布尔值拓展
        boolean flag = true;
        if(flag==true){}  //新手
        if(flag){}  //老手
        //less is more 代码要精简易读
    }
}
