package com.zhuliheng.shoppingcart.service;

import com.zhuliheng.shoppingcart.entities.Goods;
import com.zhuliheng.shoppingcart.entities.dto.GoodsNumDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: shopping-cart
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-02 15:09
 **/

public interface GoodsService {
    /**
     * 查询所有商品
     * @return
     */
    public List<Goods> findAllGoods();

    /**
     *新增商品
     * @param goods 商品信息
     */
    public void insertGoods(Goods goods);

    /**
     * 更改商品信息
     * @param goods 商品信息
     */
    public void updateGoods(Goods goods);

    /**
     * 库存更改
     * @param goodsNumDto
     */
    public void updateStock(GoodsNumDto goodsNumDto);

    public Goods findByGid(Integer gid);
    public Boolean judgeNum(Integer gid);
    public List<Goods> findByN(String name);

}
