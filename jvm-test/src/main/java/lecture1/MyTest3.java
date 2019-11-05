package lecture1;

import java.util.UUID;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-24 10:45
 **/

public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}
class MyParent3{
    public  static final String str= UUID.randomUUID().toString();
    static {
        System.out.println("MyParent3 static code");
    }
}
