import com.ucar.train.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: aop
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-19 11:02
 **/

public class AopTest {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService iAccountService=ac.getBean("accountService",IAccountService.class);
        iAccountService.saveAccount();
        iAccountService.deleteAccount();
        iAccountService.updateAccount("1");
    }
}
