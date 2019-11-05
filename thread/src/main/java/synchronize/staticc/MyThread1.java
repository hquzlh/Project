package synchronize.staticc;

import zaluan.test1.Run;

/**
 * @program: thread
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-08 15:17
 **/

public class MyThread1 implements Runnable {
    private Boolean tag;
    int i=0;
    public MyThread1(Boolean tag) {
        this.tag = tag;
    }

    @Override
    public void run() {
        while (tag=true){
            Thread.yield();
        }

        if(tag=false){
            i++;
            System.out.println(i);
            tag=true;
        }
    }
}
