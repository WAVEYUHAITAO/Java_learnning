package concurrency;

public class VolatileAtomicTest {
    public static volatile int num = 0;
    public static synchronized void increase(){ //加synchronized 每次结果就是10000，不加每次结果会因为原子操作失效而小于等于10000
        num++;
    }
    //volatile不能保证原子性，因为当进行store-write加锁时候，先加锁的会被写入主内存，然后触发cpu嗅探机制，让其他线程的运算操作结果失效
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();

        }
        for(Thread t : threads){

            t.join(); //线程停止在这里等待其他线程完成再往下执行
        }
        System.out.println(num);
    }
}
