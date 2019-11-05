package componet;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 14:11
 **/

public abstract class Component {
    public String name;
    public Component(String name) { this.name = name; }
    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract void display(int depth);

}
