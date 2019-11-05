package state;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 10:39
 **/

public class ConcreteStateA extends State {
    @Override
    public void handle(Context context) {
        System.out.println("现在是在状态A");
        context.setState(new ConcreteStateB());
    }
    }
