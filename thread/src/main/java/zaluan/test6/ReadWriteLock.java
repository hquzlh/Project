package zaluan.test6;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-15 21:29
 **/

public class ReadWriteLock {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ReadWriteLock readWriteLock=new ReadWriteLock();
            Thread thread1=new Thread(new Runnable() {
                @Override
                public void run() {
                    readWriteLock.read();
                }
            });
            thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                readWriteLock.write();
            }
        });
        thread2.start();
    }



    public void read() {
        try {
            try {
                lock.readLock().lock();
                System.out.println("获得读锁" + Thread.currentThread().getName()
                        + " " + System.currentTimeMillis());
                Thread.sleep(10000);
            } finally {
                lock.readLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void write() {
        try {
            try {
                lock.writeLock().lock();
                System.out.println("获得写锁" + Thread.currentThread().getName()
                        + " " + System.currentTimeMillis());
                Thread.sleep(10000);
            } finally {
                lock.writeLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
