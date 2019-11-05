package factory.simple;

/**
 * @program: design-patterns
 * @description: 客户端
 * @author: Mr.Zhu
 * @create: 2019-09-10 08:29
 **/

public class Client {
    static double total=0.0;

    public static void main(String[] args) {
        CashSuper cashSuper=CashFactory.createCashAccept(5);
        total+=cashSuper.acceptCash(10.0*5.0);
        System.out.println(total);
    }
}
