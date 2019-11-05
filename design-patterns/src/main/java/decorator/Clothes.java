package decorator;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-10 09:31
 **/
//decorator
public class Clothes  extends Person{
    protected Person component;
    public void decorate(Person component){
        this.component=component;
    }

    @Override
    public void show() {
        if(component!=null){
            component.show();
        }
    }
}
