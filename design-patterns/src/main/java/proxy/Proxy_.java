package proxy;

/**
 * @program: design-patterns
 * @description: 代理
 * @author: Mr.Zhu
 * @create: 2019-09-10 10:05
 **/

public class Proxy_ implements GiveGift {
    Pursuit pursuit;

    public Proxy_(Pursuit pursuit) {
        this.pursuit = pursuit;
    }

    public void giveDolls() {
        pursuit.giveDolls();
    }

    public void giveFlowers() {
        pursuit.giveFlowers();
    }

    public void giveChocolate() {
        pursuit.giveChocolate();
    }
}
