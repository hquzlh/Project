package adapter;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 11:16
 **/

public class Adapter extends Target {
    private Adaptee adaptee=new Adaptee();
    @Override
    public void  request(){
        adaptee.specificRequest();
    }
}
