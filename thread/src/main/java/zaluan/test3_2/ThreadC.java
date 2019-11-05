package zaluan.test3_2;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 17:03
 **/

public class ThreadC extends Thread {
    private Service service;
    public ThreadC(Service service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.printC();
    }
}

