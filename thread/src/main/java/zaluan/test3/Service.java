package zaluan.test3;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 16:42
 **/

public class Service {

    public void testMethod1(MyObject object) {
        synchronized (object) {
            try {
                System.out.println("testMethod1 ____getLock time="
                        + System.currentTimeMillis() + " run ThreadName="
                        + Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("testMethod1 releaseLock time="
                        + System.currentTimeMillis() + " run ThreadName="
                        + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
