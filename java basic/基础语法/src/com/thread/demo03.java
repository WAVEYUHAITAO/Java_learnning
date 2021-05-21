package com.thread;

public class demo03 {
    public static void main(String[] args) {
        //定义账户对象
        Account a = new Account();
        Account a1 = new Account(); //这里定义a1然后支付宝用a1
        //定义多线程对象
        User u_wenxin = new User(a, 2000);
        User u_zhifubao = new User(a, 2000);
        Thread weixin = new Thread(u_wenxin,"微信操作");
        Thread zhifubao = new Thread(u_zhifubao,"支付宝操作");
        weixin.start();
        zhifubao.start();
    }
}
class Account{
    public static int money = 3000;
    public synchronized void drawMoney(int m){
        /**
         * 提款方法，要判断money>=m才可以提款
         * 多线程调用这个方法，就有问题，每一次都不一样结果
         * 线程共享资源时，一个线程在执行方法没有完毕时，另一个线程又开始执行这个方法，
         * 解决方法：先让一个线程执行完这个方法，再让另一个线程执行
         * 通过synchronized同步锁来完成
         * 可以直接在方法上加synchronized关键字
         *
         * 在普通方法上加同步锁synchronized,锁的是整个对象，不是某一个方法
         * 实际操作确实是只同步了方法，锁对象有待研究
         *
         * 不同的对象是不同的锁，线程使用不同的此方法的对象，还有共享资源的问题
         *
         * 如果是针对对象要加同步锁，那就加在方法上
         * 如果针对某一块代码需要加同步锁，那就直接在代码块上加同步锁synchronized(this/a)
         */
        String name = Thread.currentThread().getName();
        if(money<m){
            System.out.println(name+","+"账户余额不足");
            System.out.println(name+","+"余额："+money);
        }else {

            System.out.println(name+","+"账户原有金额:"+money);
            System.out.println(name+","+"取款金额:"+m);
            money = money - m;
            System.out.println(name+","+"余额："+money);
        }

    }
    public synchronized void drawMoney1(int m){

        String name = Thread.currentThread().getName();
        if(money<m){
            System.out.println(name+","+"账户余额不足");
            System.out.println(name+","+"余额："+money);
        }else {

            System.out.println(name+","+"账户原有金额:"+money);
            System.out.println(name+","+"取款金额:"+m);
            money = money - m;
            System.out.println(name+","+"余额："+money);
        }

    }

    /**
     * 静态方法加同步锁，对于所有对象都是同一个锁
     * @param m
     */
    public static synchronized void drawMoney2(int m){

        String name = Thread.currentThread().getName();
        if(money<m){
            System.out.println(name+","+"账户余额不足");
            System.out.println(name+","+"余额："+money);
        }else {

            System.out.println(name+","+"账户原有金额:"+money);
            System.out.println(name+","+"取款金额:"+m);
            money = money - m;
            System.out.println(name+","+"余额："+money);
        }

    }

    /**
     * 对方法内的代码块加入同步锁synchronized(this){}
     * @param m
     */
    public void drawMoney3(int m){
        synchronized (this) { //表示当前的对象的代码块被加了同步锁
            //用this锁代码块代表当前的对象，如果在其他方法中也有synchronized(this)的代码块，使用的都是同一个同步锁
            //不同的对象还是不同的锁
            String name = Thread.currentThread().getName();
            if (money < m) {
                System.out.println(name + "," + "账户余额不足");
                System.out.println(name + "," + "余额：" + money);
            } else {

                System.out.println(name + "," + "账户原有金额:" + money);
                System.out.println(name + "," + "取款金额:" + m);
                money = money - m;
                System.out.println(name + "," + "余额：" + money);
            }
        }
    }
    public void drawMoney4(int m){
        synchronized (this) { //表示当前的对象的代码块被加了同步锁
            //用this锁代码块代表当前的对象，如果在其他方法中也有synchronized(this)的代码块，使用的都是同一个同步锁
            String name = Thread.currentThread().getName();
            if (money < m) {
                System.out.println(name + "," + "账户余额不足");
                System.out.println(name + "," + "余额：" + money);
            } else {

                System.out.println(name + "," + "账户原有金额:" + money);
                System.out.println(name + "," + "取款金额:" + m);
                money = money - m;
                System.out.println(name + "," + "余额：" + money);
            }
        }
    }

    /**
     * synchronized（this）修饰的代码块，想要根据不同的对象有不同的锁
     * @param m
     */
    public void drawMoney5(int m, Account a){
        synchronized (a) { //表示通过方法的参数传递进来的对象的代码块加了synchronized同步锁
            //不同的对象就有不同的同步锁
            //同一个对象就是相同的锁
            String name = Thread.currentThread().getName();

            //如果是微信操作的话先不操作，等支付宝操作，等支付宝操作完，微信再继续操作
            if(name.equals("微信操作")){
                try {
                    a.wait(); //如果当前进程是微信操作，先停止等待
                    //wait() notify()和notifyAll()只能用在加锁的方法或者代码块中
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (money < m) {
                System.out.println(name + "," + "账户余额不足");
                System.out.println(name + "," + "余额：" + money);
            } else {

                System.out.println(name + "," + "账户原有金额:" + money);
                System.out.println(name + "," + "取款金额:" + m);
                money = money - m;
                System.out.println(name + "," + "余额：" + money);
            }
            if(name.equals("支付宝操作")){
                try {
                   // a.notify(); //唤醒当前优先级最高的进程进入就绪状态
                    a.notifyAll();//唤醒当前所有的进程，进入就绪状态
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

class User implements Runnable{
    Account account;
    int money;
    public User(Account account, int money){
        this.account = account;
        this.money = money;
    }
    @Override
    public void run() {
        //account.drawMoney3(money);
//        if(Thread.currentThread().getName().equals("微信操作")){
//            account.drawMoney3(money);
//        }else{
//            account.drawMoney4(money);
//        }
        account.drawMoney5(money,account);

    }
}
