package state;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 10:36
 **/

public class Context {
    private State state;
    public Context(State state){
        this.state=state;
    }
    public void request(){
        this.state.handle(this);
    }
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
