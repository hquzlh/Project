/**
 * @program: algorithm
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-25 16:58
 **/

public class OutClass {
    private static int a = 0;

    public void makeInner() {
        InnerClass inClass = new InnerClass();
        inClass.seeOuter();
    }

    public static void main(String[] args) {
        OutClass oClass = new OutClass();
        oClass.makeInner();

        OutClass.InnerClass innerClass = new OutClass().new InnerClass();
        innerClass.seeOuter();
    }

    class InnerClass {

        public void seeOuter() {
            System.out.println(this);
            System.out.println(OutClass.this);
        }
    }
}