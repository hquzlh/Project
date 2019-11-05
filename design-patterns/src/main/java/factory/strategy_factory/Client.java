package factory.strategy_factory;

import strategy.CashContext1;

/**
 * @program: design-patterns
 * @description: 客户端
 * @author: Mr.Zhu
 * @create: 2019-09-10 08:29
 **/

public class Client {
    static double total=0.0;

    public static void main(String[] args) {
        CashContext2 cashContext=new CashContext2(5);
        total+=cashContext.getResult(5.0*10.0);
        System.out.println(total);
    }
}
