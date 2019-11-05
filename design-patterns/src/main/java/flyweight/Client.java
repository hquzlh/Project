package flyweight;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 10:31
 **/

public class Client {
        public static void main(String[] args) {
            int extrinsicState = 22;
            FlyWeightFactory f = new FlyWeightFactory();
            FlyWeight fx = f.getFlyWeight("X");
            fx.operation(--extrinsicState);
            FlyWeight fy = f.getFlyWeight("Y");
            fy.operation(--extrinsicState);
            FlyWeight fz = f.getFlyWeight("Z");
            fz.operation(--extrinsicState);
            FlyWeight uf = new UnsharedConcreteFlyWeight();
            uf.operation(--extrinsicState);
 }
}
