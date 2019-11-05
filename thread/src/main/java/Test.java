import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-09 10:27
 **/

public class Test {


    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <50 ; i++) {
                    System.out.println(i);
                }
            }
        });
        thread.start();
        try {
            Thread.yield();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 10; i <15 ; i++) {
            System.out.println(i);
        }

    }
}
