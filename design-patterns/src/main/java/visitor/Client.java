package visitor;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 11:25
 **/

public class Client {
    public static void main(String[] args) {
        Structure structure=new Structure();
        structure.add(new Man());
        structure.add(new Woman());
        Success success=new Success();
        structure.display(success);
        Error error=new Error();
        structure.display(error);
    }
}
