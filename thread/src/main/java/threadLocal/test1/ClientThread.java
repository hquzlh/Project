package threadLocal.test1;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-06 16:17
 **/

public class ClientThread extends Thread{
    private Sequence sequence;

    public ClientThread(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public void run() {
        for (int i = 0; i <3 ; i++) {
            System.out.println(Thread.currentThread().getName()+" => "+sequence.getNumber());
        }
    }
}
