package state;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 10:41
 **/

public class ConcreteStateC extends State {
    @Override
    public void handle(Context context) {
        System.out.println("现在是在状态C");
        context.setState(new ConcreteStateA());
    }
}
