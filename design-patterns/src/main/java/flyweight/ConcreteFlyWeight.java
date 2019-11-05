package flyweight;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 10:30
 **/
class ConcreteFlyWeight extends FlyWeight {
 @Override
 public void operation(int extrinsicState) {
System.out.println("具体FlyWeight：" + extrinsicState);
 }
}
