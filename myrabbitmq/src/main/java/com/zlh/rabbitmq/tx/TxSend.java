package com.zlh.rabbitmq.tx;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zlh.rabbitmq.util.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: myrabbitmq
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-25 15:43
 **/

public class TxSend {
    private static final String QUEUE_NAME="test_queue_tx";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String msg=new String("hello tx message");
        try {
            channel.txSelect();
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            int i=1/0;
            System.out.println(msg);
            channel.txCommit();
        } catch (Exception e) {
            channel.txRollback();
            System.out.println("tx torollback");
        }
        channel.close();
        connection.close();
    }
}
