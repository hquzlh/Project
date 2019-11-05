package singleton.inner_static;

/**
 * @program: design-patterns
 * @description:静态内部类
 * @author: Mr.Zhu
 * @create: 2019-09-11 16:15
 **/

public class Singleton{
    private static class SingletonHolder{
        public static Singleton instance = new Singleton();
    }
    private Singleton(){}
    public static Singleton newInstance(){
        return SingletonHolder.instance;
    }
}
