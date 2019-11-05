package threadLocal.test1;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-06 16:19
 **/

public class SequenceA implements Sequence {
    private static int number=0;
    @Override
    public int getNumber() {
        number+=1;
        return number;
    }

}
