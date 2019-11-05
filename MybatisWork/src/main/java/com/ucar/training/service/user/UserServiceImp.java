package com.ucar.training.service.user;

import com.ucar.training.bean.Message;
import com.ucar.training.bean.User;
import com.ucar.training.dao.AdminDao;
import com.ucar.training.dao.UserDao;
import com.ucar.training.util.NewDBUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: final
 * @description: 用户类
 * @author: Mr.Zhu
 * @create: 2019-08-08 08:45
 **/

public class UserServiceImp implements UserService {
    private SqlSession sqlSession;
    private UserDao userDao;
    public UserServiceImp(){
        sqlSession= NewDBUtil.getSqlSession();
        //使用sqlsession创建dao接口的代理对象
        userDao=sqlSession.getMapper(UserDao.class);
    }
    public   void destroy( ){
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
    @Override
    public void messageSer(Message message) {
         userDao.messageD(message);
    }

    @Override
    public Boolean checkNameSer(String uname) {
       if(userDao.selectByName(uname)!=null){
           return false;
       }else return true;
    }

    @Override
    public Boolean checkUserSer(String uname, String pwd) {
        if(userDao.selectByNP(uname, pwd)!=null){
            return true;
        }else return false;
    }

    @Override
    public void insertUser(User user) {
         userDao.insertD(user);
    }


    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public List<Message> selectMAll() {
        return userDao.selectMAll();
    }
}
