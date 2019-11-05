package visitor;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 11:13
 **/

public class Woman extends Person {


    @Override
    public void getAccept(Action action) {
        action.getWomanReaction(this);
    }
}
