package lock.test1;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-09 09:19
 **/

public class Producer extends Thread{
    private List<Integer> list;
    private Lock lock;
    private Condition condition;

    public Producer(List<Integer> list, Lock lock, Condition condition) {
        this.list = list;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
       produce();
    }
    public void produce(){
        lock.lock();
        try {
            while (true){
                if (list.size()>0){
                    list.remove(list.size()-1);
                    System.out.println(Thread.currentThread().getName()+"消费了一件商品,当前商品有"+list.size()+"件");
                    Thread.sleep(1000);
                    condition.signalAll();
                    condition.await();
                }else {
                    System.out.println(Thread.currentThread().getName()+"队列已空，等待生产者生产");
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
