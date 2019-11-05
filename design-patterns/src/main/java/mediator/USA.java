package mediator;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 10:03
 **/

public class USA extends Country {
    public USA(UnitedNations unitedNations) {
        super(unitedNations);
    }
    public void declare(String message){
        unitedNations.Declare(message,this);
    }
    public void getMessage(String message){
        System.out.println("美国获得消息："+message);
    }
}
