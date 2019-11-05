import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: testlog4j
 * @description: 测试jar包获取src下的配置文件
 * @author: Mr.Zhu
 * @create: 2019-08-12 13:32
 **/

public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        connection = JdbcUtil.getConnection();
        String sql="select * from t_student";
       preparedStatement = JdbcUtil.getPreparedStatement(sql, connection);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user=new User();
                user.setNo(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                System.out.println(user);
            }
            JdbcUtil.clossAll(resultSet,preparedStatement,connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

