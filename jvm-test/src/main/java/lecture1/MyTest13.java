package lecture1;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-24 17:21
 **/

public class MyTest13 {
    public static void main(String[] args) {
        ClassLoader classLoader=ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while (null!=classLoader){
            classLoader=classLoader.getParent();
            System.out.println(classLoader);
        }
    }
}
