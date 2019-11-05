package threadLocal.test1;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-06 16:20
 **/

public class Test {
    public static void main(String[] args) {
        Sequence sequence=new SequenceB();
        ClientThread clientThread1=new ClientThread(sequence);
        ClientThread clientThread2=new ClientThread(sequence);
        ClientThread clientThread3=new ClientThread(sequence);
        clientThread1.start();
        clientThread2.start();
        clientThread3.start();
    }
}
