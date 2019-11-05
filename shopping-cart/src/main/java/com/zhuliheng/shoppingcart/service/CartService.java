package com.zhuliheng.shoppingcart.service;

import com.zhuliheng.shoppingcart.entities.Cart;
import com.zhuliheng.shoppingcart.entities.dto.CartNumDto;
import com.zhuliheng.shoppingcart.entities.dto.GoodsNumDto;

import java.util.List;


public interface CartService {
    /**
     * 查找所有订单
     * @return
     */
    public List<Cart> findAllCart(Integer uid);

    /**
     * 清空指定用户的购物车
     * @param uid
     */
    public void deleteAllCart(Integer uid);

    /**
     * 添加商品
     * @param cart
     */
    public void insertCart(Cart cart);

    /**
     * 删除一条购物记录
     * @param id
     */
    public void deleteCart(Integer id);

    /**
     * 订单中商品数量加一
     * @param id
     */
    public void upNum(Integer id);

    /**
     * 订单中商品数量减一
     * @param id
     */
    public void downNum(Integer id);

    public Cart findById(Integer id);
    public void addMore(GoodsNumDto goodsNumDto);
    /**
     * 根据uid 和gid 查询指定购物车条目信息
     * @param uid 用户id
     * @param gid 商品id
     * @return 购物车条目信息
     */
    public Cart findByUidAndGid(Integer uid,Integer gid);

}
