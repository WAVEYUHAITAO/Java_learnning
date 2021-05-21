package com.javastudy.struct;

public class Demo04_switch01 {
    public static void main(String[] args) {
        String name = "海涛";
        //jdk7以后支持字符串，字符串本质是数字
        switch(name){
            case"秦江":
                System.out.println("秦江");
                break;
            case"海涛":
                System.out.println("海涛");
                break;
            case"狂神":
                System.out.println("狂神");
                break;
        }


    }
}
