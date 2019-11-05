package lecture1;

import java.util.Random;
import java.util.UUID;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-24 13:06
 **/

public class MyTest5 {
    public static void main(String[] args) {

        System.out.println(MyChild5.b);
    }
}
interface MyParent5 {
     Thread thread=new Thread(){
        {
            System.out.println("hello world");
        }
    };
}
class MyChild5 implements MyParent5{
    public static  int b= 1;
}