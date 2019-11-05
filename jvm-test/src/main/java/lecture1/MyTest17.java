package lecture1;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-26 09:52
 **/

public class MyTest17 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1=new MyTest16("loader1");
        Class<?> clazz=loader1.loadClass("lecture1.MySimple");
        System.out.println(clazz.hashCode());
        Object object=clazz.newInstance();

    }
}
