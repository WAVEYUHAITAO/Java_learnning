public class Demo02 {
    public static void main(String[] args) {
        //返回虚拟机的最大堆内存
        long max = Runtime.getRuntime().maxMemory();
        //返回jvm的初始堆内存
        long total = Runtime.getRuntime().totalMemory();

        System.out.println("max="+max+"字节\t"+(max/(double)1024/1024)+"MB");
        System.out.println("total="+total+"字节\t"+(total/(double)1024/1024)+"MB");
        //默认情况下：分配的总内存是电脑内存的1/4,而初始化的内存：1/64

        //16G
        //3627MB  1/4
        //245.5MB 1/64

        //-Xms1024m -Xmx1024m -XX:+PrintGCDetails
        //-Xmx 对应 Runtime.getRuntime().maxMemory() 最大堆内存，初始堆内存不能超过最大堆内存
        //-Xms 对应 Runtime.getRuntime().totalMemory() 初始堆内存

        //OOM
        //1.尝试扩大堆内存看结果
        //2.分析内存，看一下哪个地方出现问题（专业工具）
        //76288k+175104k= 251392k=245.5mb=初始化内存
        //Metaspace(元空间 也叫 非堆)逻辑上存在：物理上不存在

        //在一个项目中，突然出现OOM故障，那么该如何排除
        //1.能够看出来代码第几行出错：内存快照分析工具 MAT(ECLIPSE) ,Jprofiler
        //2.Debug ，一行行分析代码

        //Jprifiler作用：
        //分析Dump内存文件，快速定位内存泄漏
        //获得堆中的对象
    }
}
