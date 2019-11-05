package topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @program: myactivemq
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-31 10:10
 **/

public class Recv {
    public static final String ACTIVEMQ_URL="tcp://127.0.0.1:61616";
    public static final String TOPIC_NAME="topic01";
    public static void main(String[] args) throws JMSException, IOException {
        //创建连接工程，采用默认用户名密码
        ActiveMQConnectionFactory activeMQConnectionFactory=new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //获得连接Connection启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //创建会话session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地
        Topic topic = session.createTopic(TOPIC_NAME);
        MessageConsumer consumer = session.createConsumer(topic);
       //监听器方式
       consumer.setMessageListener((message)-> {
               if(null!=message&&message instanceof TextMessage){
                   TextMessage textMessage= (TextMessage) message;
                   try {
                       System.out.println("1Topic接收到的消息"+textMessage.getText());
                   } catch (JMSException e) {
                       e.printStackTrace();
                   }
               }
           }
       );
        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }
}
