package bridge;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 17:14
 **/

public abstract class Sacues {
    Steak steak;
    Sacues(Steak steak){
        this.steak=steak;
    }
    abstract String sacues();
}
