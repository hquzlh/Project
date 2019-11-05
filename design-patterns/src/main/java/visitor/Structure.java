package visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 11:23
 **/

public class Structure {
    private List<Person> personList=new ArrayList<Person>();
    public void add(Person person){
        personList.add(person);
    }
    public void remove(Person person){
        personList.remove(person);
    }
    public void display(Action action){
        for (Person p :
                personList) {
            p.getAccept(action);
        }
    }
}
