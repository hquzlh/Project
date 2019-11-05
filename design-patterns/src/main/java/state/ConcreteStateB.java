package state;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 10:40
 **/

public class ConcreteStateB extends State {
    @Override
    public void handle(Context context) {
        System.out.println("现在是在状态B");
        context.setState(new ConcreteStateC());
    }
}
