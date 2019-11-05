package observer;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 09:31
 **/

public class Security implements Watcher {
    public void update() {
        System.out.println("运输车有行动，保安戒备");
    }
}
