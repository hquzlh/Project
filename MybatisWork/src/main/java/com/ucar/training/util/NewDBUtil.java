package com.ucar.training.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: training_servlet
 * @description: 获取sqlsession
 * @author: Mr.Zhu
 * @create: 2019-08-16 14:59
 **/

public class NewDBUtil {
    private static SqlSessionFactory factory;
    static {
        InputStream is=null;
//读取配置文件
        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建SqlSessionfactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        factory=builder.build(is);

    }
    public  static SqlSession getSqlSession(){
        return factory.openSession(true);
    }
}
