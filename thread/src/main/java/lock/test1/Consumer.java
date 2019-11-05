package lock.test1;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-09 09:07
 **/

public class Consumer extends Thread {
    private List<Integer> list;
    private Lock lock;
    private Condition condition;
    @Override
    public void run() {
        consume();
    }

    public Consumer(List<Integer> list, Lock lock, Condition condition) {
        this.list = list;
        this.lock = lock;
        this.condition = condition;
    }

    public Consumer(List<Integer> list) {
        this.list = list;
    }
    public void consume(){
        lock.lock();
        try {
            while (true){
                if (list.size()<=5){
                    list.add(1);
                    System.out.println(Thread.currentThread().getName()+"生产了一件商品,当前商品有"+list.size()+"件");
                    Thread.sleep(1000);
                    condition.signalAll();
                    condition.await();
                }else {
                    System.out.println(Thread.currentThread().getName()+"队列已满，等待消费者消费");
                    condition.await();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
