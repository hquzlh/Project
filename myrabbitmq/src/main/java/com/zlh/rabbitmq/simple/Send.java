package com.zlh.rabbitmq.simple;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.zlh.rabbitmq.util.*;

import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @program: myrabbitmq
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-24 17:01
 **/

public class Send {
    private static final String QUEUE_NAME="test_simple_queue";
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection= ConnectionUtils.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        Map<String, Object> args1 = new HashMap<String, Object>();
        args1.put("x-max-priority", 10);
        //创建队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,args1);
        String msg="hello simple";

        //channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        for (int i = 0; i < 3; i++) {
            AMQP.BasicProperties.Builder builder = new
                    AMQP.BasicProperties.Builder();
            builder.priority(1);
            AMQP.BasicProperties properties = builder.build();
            channel.basicPublish("", QUEUE_NAME, properties, "低优先级1".getBytes());
        }
        for (int i = 0; i < 3; i++) {
            AMQP.BasicProperties.Builder builder = new
                    AMQP.BasicProperties.Builder();
            builder.priority(5);
            AMQP.BasicProperties properties = builder.build();
            channel.basicPublish("", QUEUE_NAME, properties, "高优先级".getBytes());
        }
        for (int i = 0; i < 3; i++) {
            AMQP.BasicProperties.Builder builder = new
                    AMQP.BasicProperties.Builder();
            builder.priority(1);
            AMQP.BasicProperties properties = builder.build();
            channel.basicPublish("", QUEUE_NAME, properties, "低优先级2".getBytes());
        }
        //System.out.println("send"+msg);
        channel.close();
        connection.close();
    }
}
