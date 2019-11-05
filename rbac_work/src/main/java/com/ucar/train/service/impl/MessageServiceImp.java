package com.ucar.train.service.impl;

import com.ucar.train.dao.MessageDao;
import com.ucar.train.domain.Message;
import com.ucar.train.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: rbac_work
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-08-20 16:48
 **/
@Service
public class MessageServiceImp  implements MessageService {

    @Autowired
     private MessageDao messageDao;
    @Override
    public List<Message> findAllMessage() {
        return messageDao.findAllMessage();
    }

    @Override
    public void insertMessage(Message message) {
        messageDao.insertMessage(message);
    }

    @Override
    public void deleteMessage(Integer bid) {
        messageDao.deleteMessage(bid);
    }

    @Override
    public void updateMessage(Message message) {
        messageDao.updateMessage(message);
    }

    @Override
    public Message findByBid(int bid) {
        return messageDao.findByBid(bid);
    }

}
