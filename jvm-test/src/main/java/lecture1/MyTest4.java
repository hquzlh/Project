package lecture1;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-24 10:49
 **/

public class MyTest4 {
    public static void main(String[] args) {
        //MyParent4 myParent4=new MyParent4();
        MyParent4[] myParent4s=new MyParent4[1];
        System.out.println(myParent4s.getClass());
    }
}
class MyParent4{
    static {
        System.out.println("MyParent4 static block");
    }
}