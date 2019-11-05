package facade;

import factory.normal.IFactory;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-10 17:08
 **/

public class Facade implements IFacade {
    SystemOne systemOne;
    SystemTwo systemTwo;

    public Facade() {
        systemOne=new SystemOne();
        systemTwo=new SystemTwo();
    }

    public void methodA() {
        System.out.println("方法组A");
        systemOne.methodOne();
        systemTwo.methodTwo();
    }

    public void methodB() {
        System.out.println("方法组B");
        systemTwo.methodTwo();
    }
}
