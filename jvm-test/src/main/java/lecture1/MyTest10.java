package lecture1;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-24 16:56
 **/
public class MyTest10 {
    static {
        System.out.println("mytest10 static block");
    }

    public static void main(String[] args) {
        Parent2 parent2;
        System.out.println("============");
        parent2=new Parent2();
        System.out.println("-----------------");
        System.out.println(parent2.a);
        System.out.println("-----------");
        System.out.println(Child2.b);
    }
}
class Parent2{
    static int a=3;
    static {
        System.out.println("parent2 static block");
    }
}
class Child2{
    static int b=2;
    static {
        System.out.println("child2 static block");
    }
}
