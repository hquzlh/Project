package lecture1;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-24 09:52
 **/

public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(MyChild1.str);
    }
}
class MyParent1{
    public static String str="hello world";
    static {
        System.out.println("MyParent1  static block");
    }
}
class MyChild1 extends MyParent1{
    public static String str2="welcome";
    static {
        System.out.println("MyChild1 static block");
    }
}
