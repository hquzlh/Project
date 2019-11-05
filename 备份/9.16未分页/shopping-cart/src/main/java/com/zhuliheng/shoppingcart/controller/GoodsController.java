package com.zhuliheng.shoppingcart.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zhuliheng.shoppingcart.entities.Goods;
import com.zhuliheng.shoppingcart.entities.Tags;
import com.zhuliheng.shoppingcart.entities.User;
import com.zhuliheng.shoppingcart.entities.dto.ThreeTagDto;
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
    @ResponseBody
    @RequestMapping("/findAll")
    public String findAllGoods(){
        List<Goods> goodsList=goodsService.findAllGoods();
        List<GoodAndFile> goodAndFileList=new ArrayList<>();
        List<Tags> tagsList=null;
        GoodAndFile goodAndFile;
        for (Goods good:goodsList) {
            String tags = goodsService.findTagByGid(good.getGid());
            goodAndFile=new GoodAndFile(good.getGid(), good.getName(), good.getPrice(), good.getNum(), tags);
            goodAndFile.setUri(good.getUri());
            goodAndFileList.add(goodAndFile);
        }
        JSONArray jsonArray=JSONArray.fromObject(goodAndFileList);
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



        goodsService.insertGoods(goods);
        Integer gid=goodsService.findByName(g.getName()).getGid();
        String[] tags=g.getTags().split("-");
        List<Tags> tagsList=new ArrayList<>();
        for (String tag:tags) {
            Tags tags1=new Tags(tag,goods.getGid());
            goodsService.insertTag(tags1);
            tagsList.add(tags1);
        }
        for (int i = 0; i <tagsList.size() ; i++) {
            if(tagsList.size()>2) {
                if (i == 0) {
                    goodsService.insertThreeTag(new ThreeTagDto(null, tagsList.get(1).getId(), gid, tagsList.get(i).getId()));
                    continue;
                } else if (i == tagsList.size() - 1) {
                    goodsService.insertThreeTag(new ThreeTagDto(tagsList.get(i - 2).getId(), null, gid, tagsList.get(i).getId()));
                    continue;
                }
                goodsService.insertThreeTag(new ThreeTagDto(tagsList.get(i - 1).getId(), tagsList.get(i + 1).getId(), gid, tagsList.get(i).getId()));
            }else if(tagsList.size()==2){
                if(i==0){
                    goodsService.insertThreeTag(new ThreeTagDto(null,tagsList.get(1).getId(),gid,tagsList.get(0).getId()));
                }else {
                    goodsService.insertThreeTag(new ThreeTagDto(tagsList.get(0).getId(),null,gid,tagsList.get(1).getId()));
                }
            }else if(tagsList.size()==1){
                goodsService.insertThreeTag(new ThreeTagDto(tagsList.get(0).getId(),null,gid,null));
            }
        }
        return "redirect:/main.html";

    }
    @ResponseBody
    @RequestMapping("/findByN")
    public String findByN(String name){
        List<Goods> goodsList=goodsService.findByN(name);
        List<GoodAndFile> goodAndFileList=new ArrayList<>();
        List<Tags> tagsList=null;
        for (Goods good:goodsList) {
            String tags=goodsService.findTagByGid(good.getGid());

            goodAndFileList.add(new GoodAndFile(good.getGid(),good.getName(),good.getPrice(),good.getNum(),tags));
        }
        JSONArray jsonArray=JSONArray.fromObject(goodAndFileList);
        return jsonArray.toString();
    }
}
