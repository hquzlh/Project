package threadLocal.test1;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-06 16:22
 **/

public class SequenceB implements Sequence {
    private static ThreadLocal<Integer> numberContainer=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    @Override
    public int getNumber() {
        numberContainer.set(numberContainer.get()+1);
        return numberContainer.get();
    }
}
