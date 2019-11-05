package com.zhuliheng.shoppingcart.mapper;

import com.zhuliheng.shoppingcart.entities.User;
import com.zhuliheng.shoppingcart.entities.dto.RecordDto;
import com.zhuliheng.shoppingcart.entities.dto.UserMoneyDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * 用户登陆检查
     * @param user 账号密码
     * @return
     */
    public User checkUser(User user);

    /**
     * 用户注册
     * @param user  注册用户
     * @return
     */
    public void insertUser(User user);

    /**
     * 充值
     * @param userMoneyDto 用户和金额
     */
    public void updateMoney(UserMoneyDto userMoneyDto);

    /**
     * 记录用户的登陆操作
     * @param recordDto 登陆信息
     */
    public void record(RecordDto recordDto);

    /**
     * 获取金额
     * @param uid 用户id
     * @return 金额
     */
    public  Integer getMoney(Integer uid);
}
