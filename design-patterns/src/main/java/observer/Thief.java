package observer;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 09:32
 **/

public class Thief implements Watcher {
    public void update() {
        System.out.println("运输车有行动，准备动手");
    }
}
