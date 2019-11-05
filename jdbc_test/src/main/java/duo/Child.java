package duo;

/**
 * @program: jdbc_test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-19 10:40
 **/

public class Child extends Parent {
    public static void t1(){
        System.out.println("child-t1");
    }
    @Override
    public void t2(){
        System.out.println("child-t2");
    }
}
