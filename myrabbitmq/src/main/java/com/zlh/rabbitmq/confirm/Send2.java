package com.zlh.rabbitmq.confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zlh.rabbitmq.util.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: myrabbitmq
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-28 09:27
 **/

public class Send2 {
    private static final String QUEUE_NAME="test_queue_confirm2";
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //生产者调用confirmSelect，不可以和事务共同使用
        channel.confirmSelect();
        String msg="hello confirm1";
        //批量发送
        for (int i = 0; i <10 ; i++) {
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        }

        if(!channel.waitForConfirms()){
            System.out.println("message send faild");
        }else {
            System.out.println("message send ok");
        }
        channel.close();
        connection.close();
    }
}
