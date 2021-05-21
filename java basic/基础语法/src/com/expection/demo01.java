package com.expection;

public class demo01 {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;

        //假设要捕获多个异常，从小到大

        try{//try 监控区域
            new demo01().a();
            System.out.println(a/b);

        }catch (Error e){//捕获异常 catch(想要捕获的异常类型)
            System.out.println("程序出现Error异常");
        }catch (Exception e){
            System.out.println("exception");
        }catch (Throwable t){
            System.out.println("throwable");
        } finally {//处理善后工作
            System.out.println("finally");
        }
        //finally可以不要， try catch必须有，  假设io，资源关系需要用到finally来关闭资源
    }

    public void a(){
        b();
    }
    public void b(){
        a();
    }


}
