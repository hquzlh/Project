package factory.strategy_factory;

import strategy.CashContext1;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-10 08:38
 **/

public class CashContext2 {
    private CashSuper cs;

    public CashContext2(int type) {
        switch (type){
            case 0:
               cs=new CashNormal();
                break;
            case 5:
                cs=new CashRebate(0.5);
                break;
            default:
                cs=new CashNormal();
        }
    }
    public double getResult(double money){
        return cs.acceptCash(money);
    }
}
