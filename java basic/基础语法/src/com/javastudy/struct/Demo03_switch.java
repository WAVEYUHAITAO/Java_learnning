package com.javastudy.struct;

public class Demo03_switch {
    public static void main(String[] args) {
        char grade = 'C';
        switch (grade){
            //每一个case后要加break，否则会出现case穿透
            //java7以后case支持string
            case'A':
                System.out.println("优秀");
                break;
            case'B':
                System.out.println("良好");
                break;
            case'C':
                System.out.println("及格");
                break;
            case'D':
                System.out.println("再接再厉");
                break;
            case'E':
                System.out.println("挂科");
                break;

        }
    }
}
