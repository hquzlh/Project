package facade;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-10 17:11
 **/

public class FacadeClient {
    public static void main(String[] args) {
        IFacade facade=new Facade();
        facade.methodA();
        facade.methodB();
    }
}
