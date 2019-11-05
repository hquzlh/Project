package bridge;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 17:15
 **/

public class HeiHuSacues extends Sacues {
    HeiHuSacues(Steak steak) {
        super(steak);
    }

    @Override
    String sacues() {
        return steak.sale()+"加了黑胡椒汁";
    }
}
