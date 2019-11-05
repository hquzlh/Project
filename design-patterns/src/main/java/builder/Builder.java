package builder;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-10 17:20
 **/

public  abstract class Builder {
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract Product getBuildResult();
}
