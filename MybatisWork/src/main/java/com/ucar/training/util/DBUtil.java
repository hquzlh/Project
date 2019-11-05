package com.ucar.training.util;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @program: training_servlet
 * @description: jdbc的封装
 * @author: Mr.Zhu
 * @create: 2019-08-14 10:32
 **/

public class DBUtil {
    public static String url="jdbc:mysql://127.0.0.1:3306/javaweb_work?useSSL=true&characterEncoding=utf-8&serverTimezone=GMT";
    public static String driver="mapper.mysql.cj.jdbc.Driver";
    public static String user="root";
    public static String password="258123";
    static {
        //获取配置文件，增加解耦性
       /* Properties p=new Properties();
        InputStream is=DBUtil.class.getResourceAsStream("db.properties");
        System.out.println(DBUtil.class.getResourceAsStream("db.properties"));*/
        try {

            //加载配置文件
           /* p.load(is);
            driver=p.getProperty("driver");
            System.out.println("-----------");
            System.out.println(driver);
            url=p.getProperty("url");
            user=p.getProperty("user");
            password=p.getProperty("password");*/
            //加载驱动
            Class.forName(driver);
            System.out.println("----------------");
        } /*catch (IOException e) {
            e.printStackTrace();
        }*/catch (ClassNotFoundException e1){
            e1.printStackTrace();
        }

    }

    /**
     * 获取与数据库的连接对象
     * @return
     */
    public static Connection getConnection(){
        Connection conn=null;
        try {
            conn= DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 获取preparedstatement
     * @param sql
     * @param conn
     * @return
     */
    public static PreparedStatement getPreparedStatement(String sql,Connection conn){
        PreparedStatement ps=null;
        try {
            ps=conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    /**
     * 获取statement
     * @param conn  数据库连接
     * @return
     */
    public Statement getStatement(Connection conn){
        Statement stmt=null;
        try {
            stmt=conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    /**
     * 关闭所有资源
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void clossAll(ResultSet rs, Statement stmt, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }}
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 封装了SQL的DML操作
     * @param sql  sql语句
     * @param objs   占位符参数
     * @return
     */
    public static int executeDML(String sql,Object...objs){
        Connection conn=getConnection();
        if(conn==null){
            System.out.println("kong");
        }
        PreparedStatement ps=DBUtil.getPreparedStatement(sql,conn);
        try {
            conn.setAutoCommit(false);//开启事务
            for(int i=0;i<objs.length;i++) {
                ps.setObject(i + 1, objs[i]);
            }
            int i= ps.executeUpdate();
            conn.commit();

//                if(i>0) {System.out.println("插入成功");}
//                else {
//                    System.out.println("没有插入");
//                };
                return i;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("插入失败");
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally {
                DBUtil.clossAll(null,ps,conn);
            }
        }

        return -1;
    }

}
