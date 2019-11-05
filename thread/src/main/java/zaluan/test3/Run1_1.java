package zaluan.test3;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 16:42
 **/

public class Run1_1 {

    public static void main(String[] args) {
        Service service = new Service();
        MyObject object = new MyObject();
        MyObject object2 = new MyObject();

        ThreadA a = new ThreadA(service, object);
        a.setName("a");
        a.start();

        ThreadB b = new ThreadB(service, object2);
        b.setName("b");
        b.start();
    }
}
