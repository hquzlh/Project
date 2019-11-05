package com.train.service;

import com.train.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: spring-tx-01
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-27 13:54
 **/
@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    @Transactional
    public  void  checkOut(String username,String isbn){
        bookDao.updateStock(isbn);

        int price =bookDao.getPrice(isbn);
        bookDao.updateBalance(username,price);
    }
}
