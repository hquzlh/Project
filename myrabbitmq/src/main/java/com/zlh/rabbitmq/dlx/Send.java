package com.zlh.rabbitmq.dlx;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zlh.rabbitmq.util.ConnectionUtils;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @program: myrabbitmq
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-29 09:10
 **/

public class Send {

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection= ConnectionUtils.getConnection();
        //获取通道
        Channel channel = connection.createChannel();


        AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
        builder.expiration("5000");//设置消息TTL
        builder.deliveryMode(2);//设置消息持久化
        AMQP.BasicProperties properties = builder.build();

        String message = String.valueOf(new Date());
        channel.basicPublish("test_dlx_exchange_begin","delay",properties,message.getBytes());
        System.out.println(message);
        channel.close();
        connection.close();

    }
}
