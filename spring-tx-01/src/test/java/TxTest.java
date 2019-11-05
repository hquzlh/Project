import com.train.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring-tx-01
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-27 14:03
 **/

public class TxTest {
    ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public  void test(){
        BookService bookService=ioc.getBean(BookService.class);
        bookService.checkOut("Tom","ISBN-001");
        System.out.println("结账完成");
    }
}
