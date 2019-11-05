import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: allTest
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-15 10:40
 **/

public class Test11 {
    public static void main(String[] args) {
        ExecutorService executors=  Executors.newFixedThreadPool(3);
        executors.execute(new MyTask());

    }
}
class MyTask extends Thread{
    @Override
    public void run() {
        for (int i = 3; i >0 ; i--) {
            System.out.println("倒计时"+i);
        }
    }
}
