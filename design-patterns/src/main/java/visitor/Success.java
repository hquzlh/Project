package visitor;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 11:15
 **/

public class Success extends Action {
    String name="成功";

    @Override
    public void getManReaction(Man man) {
        System.out.println("每一个"+this.name+"男人,背后都有无数个个漂亮的女人");
    }

    @Override
    public void getWomanReaction(Woman woman) {
        System.out.println("每一个"+this.name+"女人,背后都有无数个个帅气年轻的男人");
    }
}
