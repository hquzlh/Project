package builder;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-10 17:21
 **/

public class ConcreteBuilder1 extends Builder {
    Product product=new Product();
    @Override
    public void buildPartA() {
        product.add("部件A");
    }

    @Override
    public void buildPartB() {
        product.add("部件B");
    }

    @Override
    public Product getBuildResult() {
        return product;
    }
}
