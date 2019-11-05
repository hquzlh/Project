package iterator;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 14:44
 **/

public interface  Iterators {
    public  Object first();
    public   Object next();
    public  boolean isDone();
    public  Object currentItem();
}
