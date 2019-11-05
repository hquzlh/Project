
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @program: JdbcUtil
 * @description: JDBC连接MySQL数据库
 * @author: Mr.Zhu
 * @create: 2019-07-28 14:34
 **/

public class JdbcUtil {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    static {
        Properties p=new Properties();
        InputStream is=JdbcUtil.class.getResourceAsStream("/db.properties");
        try {
            p.load(is);
            driver=p.getProperty("driver");
            url=p.getProperty("url");
            user=p.getProperty("user");
            password=p.getProperty("password");
            //加载驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e1){
            e1.printStackTrace();
        }

    }
    public static Connection getConnection(){
        Connection conn=null;
        try {
            conn= DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static PreparedStatement getPreparedStatement(String sql,Connection conn){
        PreparedStatement ps=null;
        try {
            ps=conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
    public Statement getStatement(Connection conn){
        Statement stmt=null;
        try {
            stmt=conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }
    public static void clossAll(ResultSet rs,Statement stmt,Connection conn){
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
    public static int executeDML(String sql,Object...objs){
        Connection conn=getConnection();
        PreparedStatement ps=JdbcUtil.getPreparedStatement(sql,conn);
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
//                return i;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("插入失败");
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally {
                JdbcUtil.clossAll(null,ps,conn);
            }
        }

        return -1;
    }

}
