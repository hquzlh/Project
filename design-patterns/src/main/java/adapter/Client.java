package adapter;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 11:17
 **/

public class Client {
    public static void main(String[] args) {
        Target target=new Target();
        target.request();
        target=new Adapter();
        target.request();
    }
}
