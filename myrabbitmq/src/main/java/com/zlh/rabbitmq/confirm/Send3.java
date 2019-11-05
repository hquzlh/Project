package com.zlh.rabbitmq.confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.zlh.rabbitmq.util.ConnectionUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

/**
 * @program: myrabbitmq
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-28 09:27
 **/

public class Send3 {
    private static final String QUEUE_NAME = "test_queue_confirm3";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        final SortedSet<Long>confirmSet= Collections.synchronizedSortedSet(new TreeSet<Long>());
        channel.confirmSelect();
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long l, boolean b) throws IOException {
                if(b){
                    System.out.println("handleack - mutliple-ok");
                    confirmSet.headSet(l+1).clear();
                }else {
                    System.out.println("handleack - mutliple-fail");
                    confirmSet.remove(l);
                }
            }

            @Override
            public void handleNack(long l, boolean b) throws IOException {
                if(b){
                    System.out.println("handleack - mutliple-ok");
                    confirmSet.headSet(l+1).clear();
                }else {
                    System.out.println("handleack - mutliple-fail");
                    confirmSet.remove(l);
                } }});
        String msgStr="ssss";
        while (true){
            long seq=channel.getNextPublishSeqNo();
            channel.basicPublish("", QUEUE_NAME,null,msgStr.getBytes());
            confirmSet.add(seq);
        }
    }
}
