package lecture1;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-24 21:53
 **/

public class MyTest15 {
    public static void main(String[] args) {
        String[] strings=new String[2];
        System.out.println(strings.getClass().getClassLoader());
        System.out.println("-------------");
        MyTest15[] myTest15=new MyTest15[3];
        System.out.println(myTest15.getClass().getClassLoader());
        System.out.println("--------------");
        int [] ints=new int[3];
        System.out.println(ints.getClass().getClassLoader());
    }
}
