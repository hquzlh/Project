package test.jiaotiprint;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: thread
 * @description: 多线程交替打印ABC -lock
 * @author: Mr.Zhu
 * @create: 2019-10-21 15:25
 **/

public class Test2 {
    public static ReentrantLock lock = new ReentrantLock();
    public static int state=0;
    public static void main(String[] args) {
        new MyThreadA().start();
        new MyThreadB().start();
        new MyThreadC().start();
    }

    static class MyThreadA  extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (state%3==0){
                        System.out.println(Thread.currentThread()+"-------A");
                        state++;
                        i++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    static class MyThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (state%3==1){
                        System.out.println(Thread.currentThread()+"-------B");
                        state++;
                        i++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    static class MyThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (state%3==2){
                        System.out.println(Thread.currentThread()+"-------C");
                        state++;
                        i++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}

