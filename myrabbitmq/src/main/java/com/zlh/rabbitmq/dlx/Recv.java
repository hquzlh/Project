package com.zlh.rabbitmq.dlx;

import com.rabbitmq.client.*;
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
 * @create: 2019-10-29 09:15
 **/

public class Recv {
    public static void main(String[] args) throws IOException, TimeoutException {


        Connection connection= ConnectionUtils.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("test_dlx_exchange_begin", "direct");
        channel.queueDeclare("test_dlx_queue_begin", true, false, false, null);
        channel.queueBind("test_dlx_queue_begin", "test_dlx_exchange_begin", "delay");
        channel.exchangeDeclare("test_dlx_exchange_done", "direct");

        Map<String, Object> args1 = new HashMap<String, Object>();
        args1.put("x-dead-letter-exchange", "test_dlx_exchange_done");
        args1.put("x-dead-letter-routing-key","delay");
        //创建队列
        channel.queueDeclare("test_dlx_queue_done",false,false,false,args1);
        channel.queueBind("test_dlx_queue_done", "test_dlx_exchange_done", "delay");
        DefaultConsumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body,"utf-8"));

            }
        };
        channel.basicConsume("test_dlx_queue_done", false, consumer);

    }
}
