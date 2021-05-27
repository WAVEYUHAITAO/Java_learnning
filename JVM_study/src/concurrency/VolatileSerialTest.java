package concurrency;

import java.util.HashMap;
import java.util.HashSet;

public class VolatileSerialTest {
    public static int x = 0, y = 0;
    public static void main(String[] args) throws InterruptedException {
        HashSet<String> resultSet = new HashSet<>();
        HashMap<String, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < 100000; i++) {
            x=0; y=0;
            resultMap.clear();
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    int a = y;
                    x=1;
                    resultMap.put("a",a);
                }
            });
            Thread other = new Thread(new Runnable() {
                @Override
                public void run() {
                    int b = x;
                    y=1;
                    resultMap.put("b",b);
                }
            });
            one.start();
            other.start();
            one.join();
            other.join();
            resultSet.add("a="+resultMap.get("a")+","+"b="+resultMap.get("b"));
            System.out.println(resultSet);
        }

    }
}
