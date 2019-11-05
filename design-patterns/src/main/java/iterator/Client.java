package iterator;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 15:16
 **/

public class Client {
    public static void main(String[] args) {
        ConcreteAggregate concreteAggregate=new ConcreteAggregate();
        concreteAggregate.setItems("大鸟");
        concreteAggregate.setItems("小菜");
        concreteAggregate.setItems("小偷");
        Iterators i=new ConcreteIterator(concreteAggregate);
        Object item=i.first();
        System.out.println("首元素"+item);
        while (!i.isDone()){
            System.out.println(i.currentItem()+"请买票");
            i.next();
        }
    }

}
