package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-08 15:57
 **/

public class Main {
    //静态内部类实现线程共享
    static class Example{
        //创建lock
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        //读操作
        public void read(){
            //获取读锁并上锁
            lock.readLock().lock();
            try{
                System.out.println("读线程开始");
                Thread.sleep(1000);
                System.out.println("读线程结束");
            }catch (Exception e){
                e.printStackTrace();
            }finally{
                //解锁
                lock.readLock().unlock();
            }
        }
        //写操作
        public void write(){
            //获取写锁并上锁
            lock.writeLock().lock();
            try{
                System.out.println("写线程开始");
                Thread.sleep(1000);
                System.out.println("写线程结束");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                //解锁
                lock.writeLock().unlock();
            }
        }
    }

    public static void main(String[] args) {
        final Example example = new Example();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    example.read();
                    example.write();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    example.read();
                    example.write();
                }
            }
        }).start();
    }
}