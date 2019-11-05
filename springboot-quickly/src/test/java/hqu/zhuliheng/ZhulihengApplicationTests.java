package hqu.zhuliheng;

import hqu.zhuliheng.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZhulihengApplicationTests {

    Logger logger=LoggerFactory.getLogger(getClass());
    @Autowired
    Person person;
    @Test
    public void contextLoads() {
        logger.trace("这是trace");
        logger.debug("这是debug");
        logger.info("info");
        logger.warn("warn" );
        logger.error("error");
    }

}
