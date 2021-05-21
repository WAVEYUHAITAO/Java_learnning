package com.thread;

public class demo02 {
    public static void main(String[] args) {
        TestRun run0 = new TestRun();
        Runnable run1 = new TestRun();
        Thread t0 = new Thread(run0);
        Thread t1 = new Thread(run1,"t-1");
        System.out.println(t0.getName());//获得线程名称
        t0.setName("t-0"); //设置线程的名称
        t0.start();
        t1.start();

        System.out.println("t0的优先级"+t0.getPriority());
        //t1.setPriority(1);
        System.out.println("t0的优先级"+t0.getPriority());
        System.out.println("1-------------------------------------");
        System.out.println("2-------------------------------------");
        System.out.println(t1.isAlive());
        t1.stop();//强制线程生命期结束
        System.out.println(t1.isAlive());//这里t1不会立即被结束
        try {
            t0.join(); //插入到当前位置，阻塞当前main方法，先执行join线程的代码，还有和t0同优先级的也会被执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.isAlive());//t1
        System.out.println("3-------------------------------------");

        /**
         * 线程的优先级，就是哪个线程有较大概率被执行
         * 优先级是用数组1-10表示，数字越大优先级越高
         * 如果没有设置，默认优先级是5
         */
    }
}

class TestRun implements Runnable{
    int count = 0;
    @Override
    public void run() {
        System.out.println("Runnable多线程运行的代码");
        for(int i = 0 ; i<5 ; i++) {
            try {
                Thread.sleep(1000); //每次循环睡眠1000毫秒,让程序慢下来
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i%2==0){
                Thread.yield();//线程让步,暂停线程,把执行机会让给优先级相同或者更高的线程
            }
            count++;
            System.out.println(Thread.currentThread().getName()+"这是Runnable多线程的逻辑代码" + i+","+"count值:"+count);
        }
    }
}
