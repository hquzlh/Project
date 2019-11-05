package com.train.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @program: spring-tx-01
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-27 10:19
 **/
@Repository
public class BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public  void updateBalance(String userName,int price){
        String sql="update account set balance=balance-? where username=?";
        jdbcTemplate.update(sql,price,userName);
    }
    public int getPrice(String isbn){
        String sql="select  price from book where isbn=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
    }
    public  void updateStock(String isbn){
        String sql="update book_stock set stock=stock-1 where isbn=? ";
        jdbcTemplate.update(sql,isbn);
    }
}
