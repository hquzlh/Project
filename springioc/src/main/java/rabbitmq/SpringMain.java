package rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: springioc
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-28 10:41
 **/

public class SpringMain {
    public static void main(String[] args) throws InterruptedException {
        AbstractApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        RabbitTemplate template=context.getBean(RabbitTemplate.class);
        template.convertAndSend("hello world");
        Thread.sleep(1000);
        context.destroy();
    }
}
