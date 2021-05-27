package concurrency;

public class VolatileVisibilityTest {
    public static volatile boolean initFlag = false;
    //    在64位Windows上build的hsdis，
    //    放在$JAVA_HOME/jre/bin/server（或$JAVA_HOME/jre/bin/client）下即可。
    //    运行时可添加参数：
    //    -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly
    //    -XX:CompileCommand=compileonly,*VolatileVisibilityTest.prepareData
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("waiting Data");
                while (!initFlag){ //这里第一个线程运行时flag是false， 第二个线程改变了共享变量flag的值，但是第二个线程并不知道
                    //此时在共享变量的修饰符里加上volatile
                }
                System.out.println("=====================Success");
            }
        }).start();
        Thread.sleep(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                prepareData();
            }
        }).start();
    }
    public static void prepareData(){
        System.out.println("Preparing Data...");
        initFlag = true;
        System.out.println("Prepare data end...");
    }
}
