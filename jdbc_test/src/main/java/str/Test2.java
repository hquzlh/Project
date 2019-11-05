package str;

import java.lang.reflect.Field;

/**
 * @program: jdbc_test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-20 15:56
 **/

public class Test2 {
    private static final String str = "abc";
    private final String str2 = "efg";

    public static void main(String[] args) throws Exception {
        new Test2().fun1();
    }
    public void fun1() throws Exception {
        System.out.println(str); //abc
        System.out.println(str2); //efg
        ///////////////////////
        Field field = Test2.class.getDeclaredField("str");
        field.setAccessible(true);

        field.set(this, "cba"); //java.lang.IllegalAccessException: Can not set static final
        System.out.println(str);
    }

}
