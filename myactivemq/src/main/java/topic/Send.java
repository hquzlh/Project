package topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * @program: myactivemq
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-31 09:59
 **/

public class Send {
    public static final String ACTIVEMQ_URL="tcp://127.0.0.1:61616";
    public static final String TOPIC_NAME="topic01";
    public static void main(String[] args) throws JMSException {
        //创建连接工程，采用默认用户名密码
        ActiveMQConnectionFactory activeMQConnectionFactory=new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //获得连接Connection启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //创建会话session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地
        Topic topic = session.createTopic(TOPIC_NAME);
        //创建消息的生产者
        MessageProducer producer = session.createProducer(topic);
        for (int i = 0; i <3 ; i++) {
            //创建消息
            TextMessage message = session.createTextMessage("msg" + i);
            //发送消息给mq
            producer.send(message);
        }
        producer.close();
        session.close();
        connection.close();
        System.out.println("Topic消息发布完成");
    }
}
