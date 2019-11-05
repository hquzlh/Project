package lecture1;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-26 10:03
 **/

public class MyTest17_1 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1=new MyTest16("loader1");
        loader1.setPath("D:\\te\\");
        Class<?> clazz=loader1.loadClass("lecture1.MySimple");
        System.out.println(clazz.hashCode());
        Object object=clazz.newInstance();

    }
}
