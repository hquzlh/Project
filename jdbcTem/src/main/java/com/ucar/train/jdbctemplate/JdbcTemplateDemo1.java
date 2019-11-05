package com.ucar.train.jdbctemplate;

import com.ucar.train.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: jdbcTem
 * @description:jdbcTemplate基本用法
 * @author: Mr.Zhu
 * @create: 2019-08-19 13:27
 **/

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate=ac.getBean("jdbcTemplate" ,JdbcTemplate.class);
        //jdbcTemplate.execute("insert into account (name,money) values('ccc2',1001)");
        //List<Account> list=jdbcTemplate.query("select * from account where money > ?",new AccountRowMapper(),500);
        List<Account> list=jdbcTemplate.query("select * from account where money > ?",new BeanPropertyRowMapper<Account>(Account.class),500);
        for (Account account : list) {
            System.out.println(account);
            
        }
        //准备数据源
        /*DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql:///my_db2?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("258123");
        //创建jdbcTemplate对象
        JdbcTemplate jdbcTemplate=new JdbcTemplate(ds);
        //执行操作
        jdbcTemplate.execute("insert into account (name,money) values('ccc',1000)");
*/
    }
}
class AccountRowMapper implements RowMapper<Account> {

    public Account mapRow(ResultSet rs,int rowNum) throws SQLException{
        Account account=new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));
        return account;
    }
}
