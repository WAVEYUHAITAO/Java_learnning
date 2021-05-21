package com.javastudy.array;

public class Demo04 {
    public static void main(String[] args) {
        int[] arrays ={1,2,3,4,5};
        for(int array : arrays){     //遍历数组的元素
            System.out.println(array);
        }
        printArray(arrays);
        printArray(reverseArray(arrays));

        //幂运算 2^3
        double pow = Math.pow(2,3);
        System.out.println(pow);

        //逻辑运算符
        // 与(and) 或（or) 非(取反)
        boolean a = true;
        boolean b = false;

        System.out.println("a && b: "+(a&&b));
        System.out.println("a || b: "+(a||b));
        System.out.println("! (a && b): "+!(a&&b));

        //短路运算
        int c = 5;
        boolean d = (c>4)&&(c++<5);
        //这里如果c<4则不会执行c++，输出c为5，如果前面c>4则会判断&&后面的，c++会在判断后给c加1，所以输出c为6
        System.out.println(d);
        System.out.println(c);
        //位运算
        //2
        //0000 0010
        //16
        //0001 0000
        System.out.println(2<<3);
    }
    //打印数组元素
    public static void printArray(int[] arrays){
        for(int x: arrays){
            System.out.print(x+" ");
        }
        System.out.println();
    }
    //反转数组
    public static int[] reverseArray(int[] arrays){
        int[] result = new int[arrays.length];
        for(int i =0, j=arrays.length-1;i<arrays.length; i++,j--){ //一个for循环完成两个变量加减
            result[j]=arrays[i];
        }
        return result;
    }
}

