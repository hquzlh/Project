package mediator;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 10:07
 **/

public class Client {
    public static void main(String[] args) {
        UnitedNationsSecurityCouncil unsc=new UnitedNationsSecurityCouncil();
        USA usa=new USA(unsc);
        Iraq iraq=new Iraq(unsc);
        unsc.setUsa(usa);
        unsc.setIraq(iraq);
        usa.declare("干死伊拉克小婊砸");
        iraq.declare("说你麻痹呢");
    }


}
