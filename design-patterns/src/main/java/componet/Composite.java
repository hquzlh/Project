package componet;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 14:18
 **/

public class Composite extends Component {
    private List<Component> children=new ArrayList<Component>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void display(int depth) {
        System.out.println(StringUtils.repeat("-",depth)+this.name);
        for (Component component:children) {
            component.display(depth+2);
        }
    }

    public List<Component> getChildren() {
        return children;
    }

    public void setChildren(List<Component> children) {
        this.children = children;
    }
}
