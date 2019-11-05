package singleton.lazy;

/**
 * @program: design-patterns
 * @description: 懒汉式
 * @author: Mr.Zhu
 * @create: 2019-09-11 15:51
 **/

public  class Singleton {
    private static Singleton instance=null;
    private Singleton(){}
    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }
}
