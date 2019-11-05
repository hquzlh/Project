package com.zhuliheng.shoppingcart.service.impl;

import com.zhuliheng.shoppingcart.entities.Cart;
import com.zhuliheng.shoppingcart.entities.dto.CartNumDto;
import com.zhuliheng.shoppingcart.entities.dto.GoodsNumDto;
import com.zhuliheng.shoppingcart.mapper.CartMapper;
import com.zhuliheng.shoppingcart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: shopping-cart
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-02 15:12
 **/
@Service
public class CartServiceImp implements CartService {
    @Autowired
    CartMapper cartMapper;
    @Override
    public List<Cart> findAllCart(Integer uid) {
        return cartMapper.findAllCart(uid);
    }

    @Override
    public void deleteAllCart(Integer uid) {
        cartMapper.deleteAllCart(uid);
    }

    @Override
    public void insertCart(Cart cart) {
        List<Cart> list=cartMapper.findAllCart(cart.getUid());
        for (Cart c : list) {
            if(c.getGid().equals(cart.getGid())){
                cartMapper.upNum(c.getId());
                return;
            }
        }
        cartMapper.insertCart(cart);
    }

    @Override
    public void deleteCart(Integer id) {
        cartMapper.deleteCart(id);
    }

    @Override
    public void    upNum(Integer id) {
        cartMapper.upNum(id);
    }

    @Override
    public void downNum(Integer id) {
        cartMapper.downNum(id);
    }

    @Override
    public Cart findById(Integer id) {
        return cartMapper.findById(id);
    }

    @Override
    public void addMore(GoodsNumDto goodsNumDto) {
        cartMapper.addMore(goodsNumDto);
    }

    @Override
    public Cart findByUidAndGid(Integer uid, Integer gid) {
        return cartMapper.findByUidAndGid(uid,gid);
    }
}
