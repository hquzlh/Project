package lecture1;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-26 09:50
 **/

public class MyCat {
    public MyCat() {
        System.out.println("MyCat is  loader by"+this.getClass().getClassLoader());
        //System.out.println("MySimple "+MySimple.class);
    }
}
