package jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @program: myactivemq
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-31 10:10
 **/

public class Recv2 {
    public static final String ACTIVEMQ_URL="tcp://127.0.0.1:61616";
    public static final String QUEUE_NAME="queue01";
    public static void main(String[] args) throws JMSException, IOException {
        ActiveMQConnectionFactory activeMQConnectionFactory=new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        MessageConsumer consumer = session.createConsumer(queue);
       /* while (true){
            TextMessage message = (TextMessage) consumer.receive(4000L);
            if(message!=null){
                System.out.println("接收到的内容"+message.getText());
            }else {
                break;
            }
        }
        consumer.close();
        session.close();
        connection.close();
        System.out.println("消费者程序结束");*/
       //监听器方式
       consumer.setMessageListener(new MessageListener() {
           @Override
           public void onMessage(Message message) {
               if(null!=message&&message instanceof TextMessage){
                   TextMessage textMessage= (TextMessage) message;
                   try {
                       System.out.println("2接收到的消息"+textMessage.getText());
                   } catch (JMSException e) {
                       e.printStackTrace();
                   }
               }
           }
       });
        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }
}
