package componet;


import org.apache.commons.lang3.StringUtils;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 14:13
 **/

public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        System.out.println("不能增加节点");
    }

    @Override
    public void remove(Component component) {
        System.out.println("不能删除节点");
    }

    @Override
    public void display(int depth) {
        System.out.println(StringUtils.repeat("-",depth)+this.name);
    }
}
