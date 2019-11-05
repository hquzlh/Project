package bridge;

import java.util.Date;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-11 17:11
 **/

public class Restaurant {
    public static void main(String[] args) {
        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println("---------------------");
        Steak steak1=new BeefSteak(new Rice());
        System.out.println("卖出了一份"+steak1.sale());
        Steak steak2=new PorkSteak(new Spaghetti());
        System.out.println("迈出了一份"+steak2.sale());
        Sacues sacues=new HeiHuSacues(new BeefSteak(new Rice()));
        System.out.println("迈出了一份"+sacues.sacues());
    }
}
