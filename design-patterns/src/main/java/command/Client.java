package command;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 09:39
 **/

public class Client {
    public static void main(String[] args) {
        Waiter waiter=new Waiter();
        Barbecuer barbecuer=new Barbecuer();
        Command command1=new ChickenWingCommand(barbecuer);
        Command command2=new MuttonCommand(barbecuer);

        waiter.serOrder(command1);
        waiter.serOrder(command1);
        waiter.serOrder(command2);
        waiter.notify1();
    }
}
