import java.util.Random;
//修改了初始化堆空间和最大可用堆空间来测试
//-Xms8m -Xmx8m -XX:+PrintGCDetails
public class Hello {
    public static void main(String[] args) {
        String str = "java-study";
        while (true){
            str+=str+ new Random().nextInt(88888)+new Random().nextInt(88888);
        }
    }
}
