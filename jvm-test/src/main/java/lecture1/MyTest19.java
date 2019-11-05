package lecture1;

import java.lang.reflect.Method;
import java.util.Hashtable;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-26 11:12
 **/

public class MyTest19 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1=new MyTest16("loader1");
        MyTest16 loader2=new MyTest16("loader2");
        Class<?> clazz1=loader1.loadClass("lecture1.MyPerson");
        Class<?> clazz2=loader2.loadClass("lecture1.MyPerson");
        System.out.println(clazz1==clazz2);
        Object object1=clazz1.newInstance();
        Object object2=clazz2.newInstance();
        Method method=clazz1.getMethod("setMyPerson",Object.class);
        method.invoke(object1,object2);

    }
}
