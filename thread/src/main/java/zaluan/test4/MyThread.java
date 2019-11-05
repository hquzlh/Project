package zaluan.test4;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 17:20
 **/
public class MyThread extends Thread {
    volatile public static int count;

    private  static void addCount() {
        for (int i = 0; i < 100; i++) {
            count=i;
        }
        System.out.println("count=" + count);

    }
    @Override
    public void run() {
        addCount();
    }
}
