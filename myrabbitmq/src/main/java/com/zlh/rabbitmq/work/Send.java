package com.zlh.rabbitmq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zlh.rabbitmq.util.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: myrabbitmq
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-25 09:25
 **/

public class Send {
    private static final String QUEUE_NAME="test_work_queue";
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        int prefetchCount=1;
        channel.basicQos(prefetchCount);
        for (int i = 0; i <50 ; i++) {
            String msg="hello workqueue"+i;
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            System.out.println(msg+i);
            Thread.sleep(i*10);
        }
        channel.close();
        connection.close();




    }
}
