package visitor;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 11:22
 **/

public class Error extends Action {
    String name="失败";

    @Override
    public void getManReaction(Man man) {
        System.out.println("每一个"+this.name+"男人,背后都没有女人");
    }

    @Override
    public void getWomanReaction(Woman woman) {
        System.out.println("每一个"+this.name+"女人,背后都只有一个丑陋的男人");
    }
}
