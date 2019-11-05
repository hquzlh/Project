package mediator;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 10:04
 **/

public class Iraq extends Country {
    public Iraq(UnitedNations unitedNations) {
        super(unitedNations);
    }
    public void declare(String message){
        unitedNations.Declare(message,this);
    }
    public void getMessage(String message){
        System.out.println("伊拉克获得消息："+message);
    }
}
