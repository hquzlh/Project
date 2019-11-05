package com.zhuliheng.shoppingcart.entities.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: shopping-cart
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-05 09:53
 **/

@Data
public class GoodAndFile {
    private Integer gid;
    private String name;
    private Integer price;
    private Integer num;
    private String tags;
    private MultipartFile file;

    public GoodAndFile(Integer gid, String name, Integer price, Integer num, String tags, MultipartFile file) {
        this.gid = gid;
        this.name = name;
        this.price = price;
        this.num = num;
        this.tags = tags;
        this.file = file;
    }

    public GoodAndFile(Integer gid, String name, Integer price, Integer num, String tags) {
        this.gid = gid;
        this.name = name;
        this.price = price;
        this.num = num;
        this.tags = tags;
    }

    public GoodAndFile() {
    }
}