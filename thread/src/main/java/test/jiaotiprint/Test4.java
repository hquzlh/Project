package test.jiaotiprint;

import process.SemaphoreDemo;

import java.util.concurrent.Semaphore;

/**
 * @program: thread
 * @description:多线程交替打印ABC
 * @author: Mr.Zhu
 * @create: 2019-10-21 16:04
 **/

public class Test4 {
    public static Semaphore a=new Semaphore(1);
    public static Semaphore b=new Semaphore(0);
    public static Semaphore c=new Semaphore(0);
    public static void main(String[] args) {
        new MyThreadA().start();
        new MyThreadB().start();
        new MyThreadC().start();
    }
static class MyThreadA extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            try {
                a.acquire();
                System.out.println("a");
                b.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
    static class MyThreadB extends Thread{
        @Override
        public void run() {
            for (int i = 0; i <10 ; i++) {
                try {
                    b.acquire();
                    System.out.println("B");
                    c.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class MyThreadC extends Thread{
        @Override
        public void run() {
            for (int i = 0; i <10 ; i++) {
                try {
                    c.acquire();
                    System.out.println("C");
                    a.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


