package singleton.hungry;

/**
 * @program: design-patterns
 * @description: 饿汉式
 * @author: Mr.Zhu
 * @create: 2019-09-11 15:55
 **/

public class Singleton {
    private static final Singleton instance=new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }
}
