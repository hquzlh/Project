package com.ucar.train.service;

import com.ucar.train.domain.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAllMessage();
    void insertMessage(Message message);
    void deleteMessage(Integer bid);
    void updateMessage(Message message);
    Message findByBid(int bid);
}
