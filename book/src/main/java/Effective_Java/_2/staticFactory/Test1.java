package Effective_Java._2.staticFactory;

/**
 * @program: book
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-10 19:15
 **/

public class Test1 {
    public static void main(String[] args) {
        A a1=new A();
        A a2=new B();
        B b=new B();
        B b1=new C();
        C c=new C();
        D d=new D();
        a2.m(a1);
        a2.m(b);
        a2.m(d);
        b1.m(c);
    }
}

class A{
    public  void m(A a){
        System.out.println("a-a");
    }
    public void m(D d){
        System.out.println("a-d");
    }
}
class B extends A{
    public void m(B b){
        System.out.println("b-b");
    }
    @Override
    public void m(A a){
        System.out.println("b-a");
    }
}
class C extends B{

}
class D extends B{

}
