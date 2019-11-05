package singleton.lazy;

/**
 * @program: design-patterns
 * @description:线程安全懒汉式-双重校验
 * @author: Mr.Zhu
 * @create: 2019-09-11 16:00
 **/

public class Singleton2 {
    /*导致初始化Singleton和将对象地址赋给instance字段的顺序是不确定的。
     在某个线程创建单例对象时，在构造方法被调用之前，就为该对象分配了内存空间并将对象的字段设置为默认值。
     此时就可以将分配的内存地址赋值给instance字段了，然而该对象可能还没有初始化。
     若紧接着另外一个线程来调用getInstance，取到的就是状态不正确的对象，程序就会出错。*/
    //private static Singleton2 instance=null;
    //使用volatile避免
    private static volatile Singleton2 instance=null;
    private Singleton2(){}
    public static  Singleton2 getInstance(){
        if(instance==null){
            synchronized (Singleton2.class){
                if(instance==null){
                    instance = new Singleton2();
                }
            }

        }

        return instance;
    }
}
