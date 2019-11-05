import java.sql.*;

/**
 * @program: jdbc_test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-17 21:44
 **/

public class JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn=null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?serverTimezone=Asia/Shanghai&characterEncoding=utf8","root","258123");
        String sql="insert into test1 (password) values(?)";
        sql="select * from test1";
        PreparedStatement ps=conn.prepareStatement(sql);
        //ps.setString(1,"lisisi");
        //int i=ps.executeUpdate();
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getInt("id")+"---"+rs.getString("password"));
        }
        rs.close();
        ps.close();
        conn.close();


    }
}
