import visitor.Structure;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 15:18
 **/

public class StringTest {
    public static void main(String[] args) {
        String s0="kill";
        String s1=new String("kill");
        String s2=new String("kill");
        System.out.println("-------------");
        System.out.println(s0==s1);
        System.out.println(s1==s2);
        s1=s1.intern();
        System.out.println(s0==s1);
    }
}
