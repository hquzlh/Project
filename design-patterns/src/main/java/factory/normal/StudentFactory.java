package factory.normal;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-10 10:37
 **/

public class StudentFactory  implements IFactory{
    public LeiFeng createLeiFeng() {
        return new Student();
    }
}
