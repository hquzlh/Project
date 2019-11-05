package decorator;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 08:34
 **/
class BigTrouser extends Clothes{
    @Override
    public void show() {
        super.show();
        System.out.println("大裤衩");

    }
}
