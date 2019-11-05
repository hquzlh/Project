package template;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-10 15:58
 **/

public class ConcreteClassB extends AbstractTemplate {
    @Override
    public void primitiveOperation1() {
        System.out.println("具体类B的方法1实现");
    }

    @Override
    public void primitiveOperation2() {
        System.out.println("具体类B的方法2实现");
    }
}
