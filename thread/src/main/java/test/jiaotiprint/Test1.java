package test.jiaotiprint;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: thread
 * @description: 多线程交替打印ABC-synchornize
 * @author: Mr.Zhu
 * @create: 2019-10-21 15:18
 **/

public class Test1 {
    public static void main(String[] args) throws Exception {
        Thread a=new MyThreadA();
        Thread b=new MyThreadB();
        Thread c=new MyThreadC();
        a.start();
        a.join();
        b.start();
        b.join();
        c.start();
        c.join();
    }
    static class MyThreadA extends Thread{
        @Override
        public void run() {
            System.out.println("A");
        }
    }
    static class MyThreadB extends Thread{
        @Override
        public void run() {

            System.out.println("B");
        }
    }
    static class MyThreadC extends Thread{
        @Override
        public void run() {
            System.out.println("C");
        }
    }
}


