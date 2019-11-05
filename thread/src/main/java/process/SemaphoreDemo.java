package process;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-27 08:45
 **/



import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue),"Thread"+i);
        }
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }

}

class PrintQueue {
    private final Semaphore semaphore;

    public PrintQueue() {
        semaphore = new Semaphore(1);//这是一个二进制信号量哦，计数器值只能是0或者1；
    }

    public void printJob (Object document) {
        try {
            semaphore.acquire();//获取共享资源，如果计数器为0会等待
            long duration = (long) (Math.random()*10);
            System.out.printf("%s: PrintQueue: Printing a job during %d seconds \n",Thread.currentThread().getName(),duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();//放在finally语句块表示不管发不发生异常都会执行，都会释放资源。
        }
    }
}

class Job implements Runnable {
    private PrintQueue printQueue;
    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }
    @Override
    public void run() {
        System.out.printf("%s: Going to print a job\n",Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s: The document has been printed\n",Thread.currentThread().getName());
    }
}
