package iterator;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 15:04
 **/

public class ConcreteIterator implements Iterators {
    private ConcreteAggregate aggregate;
    private int current=0;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }


    public Object first() {
        return aggregate.getItems(0);
    }


    public Object next() {
        current++;
        if(current<aggregate.getCount()){
            return aggregate.getItems(current);
        }
        return null;
    }


    public boolean isDone() {
        return current>=aggregate.getCount()? true:false;
    }


    public Object currentItem() {
        return aggregate.getItems(current);
    }
}
