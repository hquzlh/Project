//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    public JdbcUtil() {
    }

    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

        return conn;
    }

    public static PreparedStatement getPreparedStatement(String sql, Connection conn) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return ps;
    }

    public Statement getStatement(Connection conn) {
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return stmt;
    }

    public static void clossAll(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException var6) {
                var6.printStackTrace();
            }
        }

        try {
            stmt.close();
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        try {
            conn.close();
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public static int executeDML(String sql, Object... objs) {
        Connection conn = getConnection();
        PreparedStatement ps = getPreparedStatement(sql, conn);

        try {
            conn.setAutoCommit(false);

            int i;
            for(i = 0; i < objs.length; ++i) {
                ps.setObject(i + 1, objs[i]);
            }

            i = ps.executeUpdate();
            conn.commit();
        } catch (SQLException var12) {
            var12.printStackTrace();
            System.out.println("插入失败");

            try {
                conn.rollback();
            } catch (SQLException var10) {
                var10.printStackTrace();
            } finally {
                clossAll((ResultSet)null, ps, conn);
            }
        }

        return i;
    }

    static {
        Properties p = new Properties();
        InputStream is = JdbcUtil.class.getResourceAsStream("/db.properties");

        try {
            p.load(is);
            driver = p.getProperty("driver");
            url = p.getProperty("url");
            user = p.getProperty("user");
            password = p.getProperty("password");
            Class.forName(driver);
        } catch (IOException var3) {
            var3.printStackTrace();
        } catch (ClassNotFoundException var4) {
            var4.printStackTrace();
        }

    }
}
