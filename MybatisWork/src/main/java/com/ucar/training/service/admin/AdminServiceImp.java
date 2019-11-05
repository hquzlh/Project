package com.ucar.training.service.admin;

import com.ucar.training.bean.Message;
import com.ucar.training.bean.User;
import com.ucar.training.dao.AdminDao;
import com.ucar.training.util.NewDBUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: final
 * @description: 管理员
 * @author: Mr.Zhu
 * @create: 2019-08-08 08:53
 **/

public class AdminServiceImp  implements AdminService {


    private SqlSession sqlSession;
    private AdminDao adminDao;
    public AdminServiceImp(){
        sqlSession= NewDBUtil.getSqlSession();
        //使用sqlsession创建dao接口的代理对象
        adminDao=sqlSession.getMapper(AdminDao.class);
    }
    public  void destroy() {
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }

    @Override
    public Boolean checkNameSer(String uname) {
        if(adminDao.selectByName(uname)!=null){
            return false;
        }else return true;
    }

    @Override
    public Boolean checkAdminSer(String uname, String pwd) {
         if(adminDao.selectByNP(uname,pwd)!=null){
            return true;
        }else return false;
    }

    @Override
    public void deleteSer(String name) {
         adminDao.deleteD(name);
    }

    @Override
    public void deleteMSer(String name, String date) {
         adminDao.deleteMD(name,date);
    }

    @Override
    public void updateSer(User user) {
         adminDao.updateD(user);
    }

    @Override
    public void insertSer(User admin) {
         adminDao.insertD(admin);
    }

    @Override
    public void insertUserSer(User user) {
        adminDao.insertUserD(user);
    }



    @Override
    public User selectUser(String name) {
        return adminDao.selectD(name);
    }

    @Override
    public List<User> selectUALl() {
        return adminDao.selectUAll();
    }

    @Override
    public List<User> selectAAll() {
        return adminDao.selectAAll();
    }

    @Override
    public List<Message> selectMAll() {
        return adminDao.selectMAll();
    }
}
