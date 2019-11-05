package lecture1;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-29 15:31
 **/

public class MyTest25 implements Runnable {
    private Thread thread;

    public MyTest25() {
        this.thread = new Thread(this);
        thread.start();
    }

    public void run() {
        ClassLoader classLoader=thread.getContextClassLoader();
        thread.setContextClassLoader(classLoader);
        System.out.println("class"+classLoader.getClass());
        System.out.println("parent"+classLoader.getParent().getClass());
    }

    public static void main(String[] args) {
        new MyTest25();
    }
}
