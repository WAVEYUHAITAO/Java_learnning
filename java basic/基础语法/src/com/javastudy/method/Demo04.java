package com.javastudy.method;

public class Demo04 {
    public static void main(String[] args) {
        Demo04 demo04 = new Demo04();
        demo04.method(1,33,4,5,6,7,8,9,908,6,5,4);
        printMax(1,3,40,25,01,5,60,50,80,23,51);
    }
    public void method(int... i){     //可变参数
        System.out.println(i[0]);
        System.out.println(i[1]);
        System.out.println(i[2]);
        System.out.println(i[3]);
        System.out.println(i[4]);
        System.out.println(i[5]);
    }
    public static void printMax(double... numbers){    //可变参数
        if(numbers.length==0){
            System.out.println("no argument passed");
        }
        double result = numbers[0];
        for(int i=1 ; i<numbers.length ; i++){
            if(numbers[i]>result){
                result=numbers[i];
            }
        }
        System.out.println("The max value is "+result);
    }

}
