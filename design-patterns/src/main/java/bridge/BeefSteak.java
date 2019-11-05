package bridge;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 17:09
 **/

public class BeefSteak extends Steak {
    BeefSteak(Rations rations) {
        super(rations);
    }

    @Override
    public String sale() {
        return "牛扒"+(rations==null?"":rations.rations());
    }
}
