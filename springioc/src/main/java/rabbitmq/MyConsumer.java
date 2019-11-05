package rabbitmq;

/**
 * @program: springioc
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-28 10:40
 **/

public class MyConsumer {
    public void listen(String foo){
        System.out.println("消费者"+foo);
    }
}
