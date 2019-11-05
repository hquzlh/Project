package visitor;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 11:11
 **/

public class Man extends Person {

    @Override
    public void getAccept(Action action) {
        action.getManReaction(this);
    }
}
