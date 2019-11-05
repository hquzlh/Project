package template;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-10 15:59
 **/

public class TemplateClient {
    public static void main(String[] args) {
        AbstractTemplate abstractTemplate;
        abstractTemplate=new ConcreteClassA();
        abstractTemplate.templateMethod();
        abstractTemplate=new ConcreteClassB();
        abstractTemplate.templateMethod();
    }
}
