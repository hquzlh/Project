package bridge;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 17:10
 **/

public class PorkSteak extends Steak {
    PorkSteak(Rations rations) {
        super(rations);
    }

    @Override
    public String sale() {
        return "猪扒"+(rations==null?"":rations.rations());
    }
}
