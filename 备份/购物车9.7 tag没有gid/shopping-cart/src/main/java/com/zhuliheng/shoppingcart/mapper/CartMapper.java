package com.zhuliheng.shoppingcart.mapper;

import com.zhuliheng.shoppingcart.entities.Cart;
import com.zhuliheng.shoppingcart.entities.dto.CartNumDto;
import com.zhuliheng.shoppingcart.entities.dto.GoodsNumDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartMapper {

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
     * 购物车添加一个商品
     * @param cart
     */
    public void insertCart(Cart cart);

    /**
     * 购物车删除一个商品
     * @param id
     */
    public void deleteCart(Integer id);

    /**
     * 购物车中商品数量加一
     * @param id
     */
    public void upNum(Integer id);

    /**
     * 购物车中商品数量减一
     * @param id
     */
    public void downNum(Integer id);

    /**
     * 根据id查找购物车
     * @param id 购物车id
     * @return
     */
    public Cart findById(Integer id);

    /**
     * 批量增加商品
     * @param goodsNumDto 商品id和数量
     */
    public void addMore(GoodsNumDto goodsNumDto);

}
