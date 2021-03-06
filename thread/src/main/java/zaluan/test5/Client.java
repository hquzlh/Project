package zaluan.test5;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-14 11:56
 **/

public class Client {

    public static void main(String[] args) {

        try {
            Object lock = new Object();

            ThreadA a = new ThreadA(lock);
            a.start();

            Thread.sleep(50);

            ThreadB b = new ThreadB(lock);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
