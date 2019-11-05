package bridge;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 17:17
 **/

public class FanQieSacues extends Sacues {
    FanQieSacues(Steak steak) {
        super(steak);
    }

    @Override
    String sacues() {
        return steak.sale()+"加了番茄汁";
    }
}
