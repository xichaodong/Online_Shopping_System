package com.shop.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @author: chaodong.xi
 * @since: 2018/2/6
 */
public interface PictureService {

    public Map uploadPicture(MultipartFile uploadFile) throws IOException;
}
