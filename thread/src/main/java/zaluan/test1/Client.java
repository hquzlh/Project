package zaluan.test1;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 16:17
 **/

public class Client {
    public static void main(String[] args) {
        System.out.println("main thread run priority="+Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("main thread end   priority="
                + Thread.currentThread().getPriority());
        MyThread1 thread1 = new MyThread1();
        thread1.start();

    }
}
