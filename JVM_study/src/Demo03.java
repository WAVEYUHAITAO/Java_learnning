import java.util.ArrayList;

//Dump文件
//-Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError   这行代码可以生成在jprofiler打开的dump file 转储文件 java_pid15712.hprof
public class Demo03 {
    byte[] array = new byte[1*1024*1024];
    public static void main(String[] args) {

        ArrayList<Demo03> list = new ArrayList<>();
        int count = 0;

        try {
            while(true){
                list.add(new Demo03());
                count+=1;
            }
        } catch (Error e) {
            System.out.println("count:"+count);
            e.printStackTrace();
        }
    }
}
