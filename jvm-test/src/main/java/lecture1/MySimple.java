package lecture1;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-26 09:51
 **/

public class MySimple {
    public MySimple() {
        System.out.println("MySimple is loader by"+this.getClass().getClassLoader());
        new MyCat();
        System.out.println("MyCat"+MyCat.class);
    }
}
