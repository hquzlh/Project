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
    private String one_tag;
    private String two_tag;
    private MultipartFile file;

}