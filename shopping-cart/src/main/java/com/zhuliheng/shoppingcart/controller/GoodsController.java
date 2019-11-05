package com.zhuliheng.shoppingcart.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zhuliheng.shoppingcart.entities.Cart;
import com.zhuliheng.shoppingcart.entities.Goods;
import com.zhuliheng.shoppingcart.entities.Tags;
import com.zhuliheng.shoppingcart.entities.User;
import com.zhuliheng.shoppingcart.entities.dto.ThreeTagDto;
import com.zhuliheng.shoppingcart.entities.vo.GoodAndFile;
import com.zhuliheng.shoppingcart.service.GoodsService;
import com.zhuliheng.shoppingcart.util.CodeUtil;
import com.zhuliheng.shoppingcart.util.JedisPoolUtil;
import com.zhuliheng.shoppingcart.util.UploadUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: shopping-cart
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-02 15:53
 **/
@Controller
@RequestMapping("/good")
public class GoodsController {

    @Autowired
    GoodsService goodsService;
    //redis连接池
    JedisPool jedisPool= JedisPoolUtil.getJedisPoolInstance();
    @ResponseBody
    @RequestMapping("/findAll")
    public String findAllGoods(Integer num){
        List<GoodAndFile> goodAndFileList;
        Jedis jedis=jedisPool.getResource();
        String c= CodeUtil.decode(jedis.get("goodAndFileList"));
        if(!"".equals(c)){
            goodAndFileList= JSON.parseArray(c, GoodAndFile.class);
        }else {
            goodAndFileList=goodsService.findGoodsDetail();
            jedis.set("goodAndFileList", CodeUtil.encode(goodAndFileList));
        }
        int size=goodAndFileList.size();
        long total=size%8==0?size/8:size/8+1;
        List list=new ArrayList();
        list.add(total);
        if(num!=null){
            int last= num*8>size?size%8+(num-1)*8:num*8;
            list.add(goodAndFileList.subList((num-1)*8,last));
        }else {
            list.add(goodAndFileList.subList(0,8));
        }
        JedisPoolUtil.release(jedis);
        JSONArray jsonArray=JSONArray.fromObject(list);
        return jsonArray.toString();
    }
    @RequestMapping("/insert")
    public String insertGood(GoodAndFile g) {
        Goods goods =null;

        String fileName = g.getFile().getOriginalFilename();
        File newFile=null;
        File fileDir = UploadUtil.getImgDirFile();
        try {
            // 构建真实的文件路径
            newFile = new File(fileDir.getAbsolutePath() + File.separator + fileName);
            // 上传图片到 -》 “绝对路径”
            g.getFile().transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String uri = newFile.getAbsolutePath();
        uri=uri.split("static")[1].replace("\\","/");
        goods = new Goods(g.getGid(),g.getName(), g.getPrice(), g.getNum(), uri);
        //存入数据库
        goodsService.insertGoods(goods);

        //Integer gid=goodsService.findByName(g.getName()).getGid();
        String[] tags=g.getTags().split("-");
        List<Tags> tagsList=new ArrayList<>();
        for (String tag:tags) {
            Tags tags1=new Tags(tag,goods.getGid());
            goodsService.insertTag(tags1);
            tagsList.add(tags1);
        }
        //redis更新
        Jedis jedis=jedisPool.getResource();
        List<GoodAndFile> goodAndFileList=goodsService.findGoodsDetail();
        jedis.set("goodAndFileList", CodeUtil.encode(goodAndFileList));
        JedisPoolUtil.release(jedis);
        return "redirect:/main.html";

    }
    @ResponseBody
    @RequestMapping("/findByN")
    public String findByN(String name){
        List<Goods> goodsList=goodsService.findByN(name);
        List<GoodAndFile> goodAndFileList=new ArrayList<>();

        for (Goods good:goodsList) {
            String tags=goodsService.findTagByGid(good.getGid());

            goodAndFileList.add(new GoodAndFile(good.getGid(),good.getName(),good.getPrice(),good.getNum(),tags));
        }
        JSONArray jsonArray=JSONArray.fromObject(goodAndFileList);
        return jsonArray.toString();
    }

}
