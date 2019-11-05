package factory.normal;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-10 10:39
 **/

public class VolunteerFactory implements IFactory {
    public LeiFeng createLeiFeng() {
        return new Volunteer();
    }
}
