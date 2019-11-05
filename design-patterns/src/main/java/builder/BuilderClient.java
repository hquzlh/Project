package builder;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-10 17:23
 **/

public class BuilderClient {
    public static void main(String[] args) {
        Director director=new Director();

        Builder builder1=new ConcreteBuilder1();
        director.construct(builder1);
        Product product1=builder1.getBuildResult();
        product1.show();

        Builder builder2=new ConcreteBuilder2();
        director.construct(builder2);
        Product product2=builder2.getBuildResult();
        product2.show();
    }
}
