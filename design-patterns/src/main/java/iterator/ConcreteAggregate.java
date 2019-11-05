package iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 14:42
 **/

public class ConcreteAggregate implements Aggregate {
    private List<String> items=new ArrayList<String>();
    public Iterators createIterator() {
        return new ConcreteIterator(this);
    }


    public Object getItems(int index) {
        return items.get(index);
    }
    public int getCount(){
        return items.size();
    }
    public void setItems(String o) {
        items.add(o);
    }
}
