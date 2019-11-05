package decorator;

/**
 * @program: design-patterns
 * @description: 客户测试端
 * @author: Mr.Zhu
 * @create: 2019-09-10 09:34
 **/

public class Client {
    public static void main(String[] args) {
        Person person=new Person("萌宝");
        System.out.println("1-----");
        TShits tShits=new TShits();
        BigTrouser bigTrouser=new BigTrouser();
        tShits.decorate(person);
        bigTrouser.decorate(tShits);
        bigTrouser.show();
    }


}
