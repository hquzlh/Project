package strategy;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-10 08:38
 **/

public class CashContext1 {
    private CashSuper cs;

    public CashContext1(CashSuper cs) {
        this.cs = cs;
    }
    public double getResult(double money){
        return cs.acceptCash(money);
    }
}
