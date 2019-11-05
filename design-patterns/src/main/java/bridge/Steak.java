package bridge;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 17:08
 **/

public  abstract class Steak {
    Rations rations;
    Steak(Rations rations){
        this.rations=rations;
    }
    public abstract String sale();
}
