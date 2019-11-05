package aspectj;

/**
 * @program: jdbc_test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-18 11:16
 **/

public class HelloWorld {
    public void say(){
        System.out.println("hello world!");
    }

    public static void main(String[] args) {
        HelloWorld helloWorld=new HelloWorld();
        helloWorld.say();
    }
}
