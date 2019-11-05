package com.zhuliheng.shoppingcart.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zhuliheng.shoppingcart.entities.Goods;
import com.zhuliheng.shoppingcart.entities.vo.GoodAndFile;
import com.zhuliheng.shoppingcart.service.GoodsService;
import com.zhuliheng.shoppingcart.util.UploadUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
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
    @ResponseBody
    @RequestMapping("/findAll")
    public String findAllGoods(){
        List<Goods> goodsList=goodsService.findAllGoods();
        JSONArray jsonArray=JSONArray.fromObject(goodsList);
        return jsonArray.toString();
    }
    @RequestMapping("/insert")
    public String insertGood(GoodAndFile g) {
        String fileName = g.getFile().getOriginalFilename();
        File newFile=null;
        File fileDir = UploadUtil.getImgDirFile();
        System.out.println("fileDir"+fileDir.getAbsolutePath());
        try {
            // 构建真实的文件路径
            newFile = new File(fileDir.getAbsolutePath() + File.separator + fileName);
            System.out.println("newFile"+newFile.getAbsolutePath());
            // 上传图片到 -》 “绝对路径”
            g.getFile().transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String uri = newFile.getAbsolutePath();
        uri=uri.split("static")[1].replace("\\","/");
        Goods goods = new Goods(g.getGid(), g.getName(), g.getPrice(), g.getNum(), g.getOne_tag(), g.getTwo_tag(), uri);
        goodsService.insertGoods(goods);
        return "redirect:/main.html";

    }
    @ResponseBody
    @RequestMapping("/findByN")
    public String findByN(String name){
        List<Goods> goodsList=goodsService.findByN(name);
        JSONArray jsonArray=JSONArray.fromObject(goodsList);
        return jsonArray.toString();
    }
}
