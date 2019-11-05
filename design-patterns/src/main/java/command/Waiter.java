package command;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 09:37
 **/

public class Waiter {
    List<Command> commandList=new ArrayList<Command>();
    public void serOrder(Command command){
        commandList.add(command);
    }
    public void removeOrder(Command command){
        commandList.remove(command);
    }
    public void notify1(){
        for (Command c : commandList) {
            c.excuteCommand();
        }
    }
}
