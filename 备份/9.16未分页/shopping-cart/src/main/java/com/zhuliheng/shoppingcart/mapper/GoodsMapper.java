package com.zhuliheng.shoppingcart.mapper;

import com.zhuliheng.shoppingcart.entities.Goods;
import com.zhuliheng.shoppingcart.entities.Tags;
import com.zhuliheng.shoppingcart.entities.dto.GoodsNumDto;
import com.zhuliheng.shoppingcart.entities.dto.ThreeTagDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: shopping-cart
 * @description: 商品
 * @author: Mr.Zhu
 * @create: 2019-09-02 14:23
 **/

@Repository
public interface GoodsMapper {

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

    /**
     * 查找商品
     * @param gid  商品id
     * @return 商品信息
     */
    public Goods findByGid(Integer gid);
    /**
     * 商品模糊搜索
     * @param name  商品模糊搜索
     * @return 商品信息
     */
    public List<Goods> findByN(String name);

    /**
     * 根据商品名查询
     * @param name
     * @return
     */
    public Goods  findByName(String name);

    public void insertTag(Tags tags);
    public void insertThreeTag(ThreeTagDto threeTagDto);
    public List<Tags> findTagByGid(Integer gid);
}
