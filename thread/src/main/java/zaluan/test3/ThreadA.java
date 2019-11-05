package zaluan.test3;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 16:42
 **/

public class ThreadA extends Thread {

    private Service service;
    private MyObject object;

    public ThreadA(Service service, MyObject object) {
        super();
        this.service = service;
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        service.testMethod1(object);
    }
}