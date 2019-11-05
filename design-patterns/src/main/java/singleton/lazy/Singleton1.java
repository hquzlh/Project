package singleton.lazy;

/**
 * @program: design-patterns
 * @description:   线程同步懒汉式
 * @author: Mr.Zhu
 * @create: 2019-09-11 15:58
 **/

public class Singleton1 {
    private static Singleton1 instance=null;
    private Singleton1(){}
    //单校验，每次实例化都要加锁，造成不必要阻塞
    public static synchronized Singleton1 getInstance(){
        if(instance==null){
            instance = new Singleton1();
        }
        return instance;
    }
}
