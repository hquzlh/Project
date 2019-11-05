package factory.simple;

/**
 * @program: design-patterns
 * @description: 工厂
 * @author: Mr.Zhu
 * @create: 2019-09-10 08:25
 **/

public class CashFactory {
    public static CashSuper createCashAccept(int type){
        CashSuper cs=null;
        switch (type){
            case 0:
                cs=new CashNormal();
                break;
            case 5:
                cs=new CashRebate(0.5);
                break;

        }
        return cs;
    }
}
