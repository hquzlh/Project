package lock.test2;



import java.util.ArrayList;
import java.util.List;



/**
 * @program: thread
 * @description:生产者消费者轮流消费模型
 * @author: Mr.Zhu
 * @create: 2019-10-09 09:22
 **/


public class Client {
    private static List<Integer>list=new ArrayList<>(10);


    public static void main(String[] args) {
        Thread thread1=new Consumer(list);
        thread1.setName("生产者");
        thread1.start();
        Thread thread2=new Producer(list);
        thread2.setName("消费者");
        thread2.start();
    }
}
