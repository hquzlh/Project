package flyweight;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 10:29
 **/

//所有具体享元类的超类，接受并作用于外部状态
public abstract class FlyWeight {
 public abstract void operation(int extrinsicState);
}

