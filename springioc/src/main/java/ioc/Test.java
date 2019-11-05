package ioc;

import ioc.bean.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @program: springioc
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-22 14:55
 **/

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book=applicationContext.getBean(Book.class);
        book.setBookName("spring核心");
        System.out.println(book);
    }
}
