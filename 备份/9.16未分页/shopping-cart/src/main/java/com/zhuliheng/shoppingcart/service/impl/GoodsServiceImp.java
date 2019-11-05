package com.zhuliheng.shoppingcart.service.impl;

import com.zhuliheng.shoppingcart.entities.Goods;
import com.zhuliheng.shoppingcart.entities.Tags;
import com.zhuliheng.shoppingcart.entities.dto.GoodsNumDto;
import com.zhuliheng.shoppingcart.entities.dto.ThreeTagDto;
import com.zhuliheng.shoppingcart.mapper.GoodsMapper;
import com.zhuliheng.shoppingcart.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: shopping-cart
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-02 15:11
 **/
@Service
public class GoodsServiceImp implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> findAllGoods() {
        return goodsMapper.findAllGoods();
    }

    @Override
    public void insertGoods(Goods goods) {
        goodsMapper.insertGoods(goods);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsMapper.insertGoods(goods);
    }

    @Override
    public void updateStock(GoodsNumDto goodsNumDto) {
        goodsMapper.updateStock(goodsNumDto);
    }

    @Override
    public Goods findByGid(Integer gid) {
        return goodsMapper.findByGid(gid);
    }

    /**
     * 判断是否还有库存
     * @param gid 商品id
     * @return true=有库存
     */
    @Override
    public Boolean judgeNum(Integer gid){
        if(findByGid(gid).getNum()>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Goods> findByN(String name) {
        name="%"+name+"%";
        return goodsMapper.findByN(name);
    }

    @Override
    public Goods findByName(String name) {
        return goodsMapper.findByName(name);
    }

    @Override
    public void insertTag(Tags tag) {
        goodsMapper.insertTag(tag);
    }

    @Override
    public void insertThreeTag(ThreeTagDto threeTagDto) {
        goodsMapper.insertThreeTag(threeTagDto);

    }

    @Override
    public String findTagByGid(Integer gid) {
        String tags="";
        List<Tags> tagsList=null;
        tagsList=goodsMapper.findTagByGid(gid);
        for (int i = 0; i <tagsList.size() ; i++) {
            if(i!=tagsList.size()-1){
                tags+=tagsList.get(i).getTag_name()+"-";
            }else {
                tags+=tagsList.get(i).getTag_name();
            }
        }
        return tags;
    }
}
