package com.shop.controller;

import com.shop.common.utils.JsonUtils;
import com.shop.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @author: chaodong.xi
 * @since: 2018/2/6
 */

@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public String pictureUpload(MultipartFile uploadFile) throws IOException {
        Map result = pictureService.uploadPicture(uploadFile);

        String json = JsonUtils.objectToJson(result);
        return json;
    }
}
