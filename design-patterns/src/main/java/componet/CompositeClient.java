package componet;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 14:21
 **/

public class CompositeClient {
    public static void main(String[] args) {
        Composite root=new Composite("root");
        root.add(new Leaf("Leaf A"));
        root.add(new Leaf("Leaf B"));
        Composite compositeX=new Composite("composite X");
        compositeX.add(new Leaf("leaf X-A"));
        compositeX.add(new Leaf("Leaf X-B"));
        root.add(compositeX);
        Composite compositeXY = new Composite("Composite X-Y");
        compositeXY.add(new Leaf("Leaf X-Y-A"));
        compositeXY.add(new Leaf("Leaf X-Y-B"));
        compositeX.add(compositeXY);
        // 显示大树的样子
        root.display(1);

    }
}
