package factory.normal;

/**
 * @program: design-patterns
 * @description: 客户测试端
 * @author: Mr.Zhu
 * @create: 2019-09-10 10:40
 **/

public class Client {
    public static void main(String[] args)throws Exception {
        //IFactory factory = new StudentFactory();
        IFactory factory= (IFactory) Class.forName("factory.normal.StudentFactory").newInstance();
        LeiFeng student = factory.createLeiFeng();
        student.wash();
        student.buyRice();
    }


}
