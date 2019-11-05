package duo;

/**
 * @program: jdbc_test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-19 10:41
 **/

public class Client {
    public static void main(String[] args) {
        Child child=new Child();
        Parent p=child;
        p.t2();
        p.t1();

    }
}
