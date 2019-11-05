package lecture1;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-24 17:04
 **/

public class MyTest11 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader=ClassLoader.getSystemClassLoader();

        Class clazz=loader.loadClass("lecture1.CL");

        System.out.println(clazz);
        
        System.out.println("---------------");
        clazz=Class.forName("lecture1.CL");

        System.out.println(clazz);
    }
}
class CL{
    static {
        System.out.println("Class CL");
    }
}
