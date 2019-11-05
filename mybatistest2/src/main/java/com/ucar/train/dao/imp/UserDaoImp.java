package com.ucar.train.dao.imp;

import com.ucar.train.dao.IUserDao;
import com.ucar.train.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @program: mybatistest2
 * @description: UserDao实现类
 * @author: Mr.Zhu
 * @create: 2019-08-13 13:29
 **/

public class UserDaoImp implements IUserDao {
    private SqlSessionFactory sqlSessionFactory;
    public UserDaoImp(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory=sqlSessionFactory;
    }
    public List<User> finAll() {
        //使用工厂创建SqlSession对象
        SqlSession session=sqlSessionFactory.openSession();
        //使用session执行所有查询方法
        List<User> users=session.selectList("com.ucar.train.dao.IUserDao.finAll");
        session.close();
        return users;
    }
}
