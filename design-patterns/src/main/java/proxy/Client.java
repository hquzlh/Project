package proxy;

/**
 * @program: design-patterns
 * @description: 客户测试端
 * @author: Mr.Zhu
 * @create: 2019-09-10 10:06
 **/

public class Client {
    public static void main(String[] args) {
        SchoolGirl pp =new SchoolGirl("ypp");
        Pursuit pursuit=new Pursuit(pp);
        pursuit.setName("zlh");
        pursuit.giveChocolate();
        System.out.println("===========");
        Proxy_ daili=new Proxy_(pursuit);
        daili.giveDolls();
        daili.giveFlowers();
        daili.giveChocolate();
    }

}
