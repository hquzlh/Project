package test.jiaotiprint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: thread
 * @description:多线程交替打印ABC-condition
 * @author: Mr.Zhu
 * @create: 2019-10-21 15:40
 **/

public class Test3 {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition conditionA=lock.newCondition();
    public static Condition conditionB=lock.newCondition();
    public static Condition conditionC=lock.newCondition();
    public static int state=0;
    public static void main(String[] args) {
        new Test2.MyThreadA().start();
        new Test2.MyThreadB().start();
        new Test2.MyThreadC().start();
    }

    static class MyThreadA  extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (state%3!=0){
                        conditionA.await();
                    }
                    System.out.println(Thread.currentThread()+"-------A");
                    state++;
                    conditionB.signal();
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
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (state%3!=1){
                        conditionB.await();
                    }
                    System.out.println(Thread.currentThread()+"-------B");
                    state++;
                    conditionC.signal();

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
            for (int i = 0; i < 10;i++ ) {
                try {
                    lock.lock();
                    while (state%3==2){
                       conditionC.await();
                    }
                    System.out.println(Thread.currentThread()+"-------C");
                    state++;
                    conditionA.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}