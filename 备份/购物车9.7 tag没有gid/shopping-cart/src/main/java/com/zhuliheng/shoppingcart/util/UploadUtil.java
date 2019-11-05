package com.zhuliheng.shoppingcart.util;

import java.io.File;

/**
 * @program: shopping-cart
 * @description: 构建文件上传保存路径
 * @author: Mr.Zhu
 * @create: 2019-09-05 10:12
 **/

public class UploadUtil {
    public final static String IMG_PATH_PREFIX = "static/upload";

    public static File getImgDirFile(){

        // 构建上传文件的存放 "文件夹" 路径
        String fileDirPath = new String("src/main/resources/" + IMG_PATH_PREFIX);

        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }

}
