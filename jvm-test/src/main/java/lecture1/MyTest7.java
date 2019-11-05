package lecture1;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-24 16:35
 **/

public class MyTest7 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz=Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());
        Class clazz1=Class.forName("lecture1.C");
        System.out.println(clazz1.getClassLoader());
    }
}
class C{

}
