package com.ucar.train.test;

import com.ucar.train.dao.IUserDao;
import com.ucar.train.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @program: Mybatis
 * @description: 第一次mybatis项目
 * @author: Mr.Zhu
 * @create: 2019-08-13 11:14
 **/

public class MybatisTest {
    public static void main(String[] args)  throws  Exception{
        //读取配置文件
        InputStream is= Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionfactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(is);
        //使用工厂创建sqlsession对象
        SqlSession session=factory.openSession();
        //使用sqlsession创建dao接口的代理对象
        IUserDao iUserDao=session.getMapper(IUserDao.class);
        //使用代理对象执行方法
        List<User> users=iUserDao.finAll();
        for(User user:users){
            System.out.println(user);
        }
        //释放资源
        session.close();
        is.close();
    }
}
