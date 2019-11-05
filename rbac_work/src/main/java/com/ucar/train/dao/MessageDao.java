package com.ucar.train.dao;

import com.ucar.train.domain.Message;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MessageDao {
    /**
     *
     * @return 返回所有留言信息
     */
    List<Message> findAllMessage();

    /**
     *  新增留言
     * @param message  新发布的留言
     */
    void insertMessage(Message message);

    /**
     *  删除留言
     * @param bid 留言号
     */
    void deleteMessage(Integer bid);

    /**
     *  更改留言
     * @param message  需要更新的留言
     */
    void updateMessage(Message message);

    /**
     *
     * @param bid  留言ID
     * @return  返回指定bid的留言
     */
    Message findByBid(int bid);
}
