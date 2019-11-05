package strategy;

/**
 * @program: design-patterns
 * @description: 客户端
 * @author: Mr.Zhu
 * @create: 2019-09-10 08:29
 **/

public class Client {
    static double total=0.0;

    public static void main(String[] args) {
        CashContext1 cashContext=null;
        int type=5;
        switch (type){
            case 0:
                cashContext=new CashContext1(new CashNormal());
                break;
            case 5:
                cashContext=new CashContext1(new CashRebate(0.5));
                break;
            default:
                cashContext=new CashContext1(new CashNormal());
        }
        total+=cashContext.getResult(5.0*10.0);
        System.out.println(total);
    }
}
