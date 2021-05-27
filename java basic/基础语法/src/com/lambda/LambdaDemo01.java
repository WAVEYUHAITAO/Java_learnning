package com.lambda;

public class LambdaDemo01 {
    interface Printer{
        void print(String val);
    }

    public void printSomething(String something, Printer printer){
        printer.print(something);
    }

    public static void main(String[] args) {
        LambdaDemo01 lambdaDemo01 = new LambdaDemo01();
        String some ="lambda expression";
//        Printer printer = new Printer() {
//            @Override
//            public void print(String val) {
//                System.out.println(val);
//            }
//        };
//          用lambda表达式简化
//        Printer printer =(String val)->{
//            System.out.println(val);
//        };
        //进一步简化
//        Printer printer =val->{  //只有一个参数括号也可以去掉
//            System.out.println(val);
//        };
//      进一步简化
//        Printer printer =val->System.out.println(val);

        //如果实现的接口没有参数
        //()->System.out.println("")
        //表达式左边是参数右边是函数体
        lambdaDemo01.printSomething(some,val->System.out.println(val));
    }
}
