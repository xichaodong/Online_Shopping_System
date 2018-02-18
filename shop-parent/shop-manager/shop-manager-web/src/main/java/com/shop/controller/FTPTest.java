package com.shop.controller;

import com.shop.common.utils.FtpUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;

public class FTPTest {

    @Test
    public void testFtpClient() throws Exception{
        FileInputStream inputStream = new FileInputStream(new File("G:\\test.jpg"));
        FtpUtil.uploadFile("192.168.77.130", 21,  "ftpuser", "951211leo", "/home/ftpuser/images", "/2017/09/08", "hello.jpg", inputStream);
    }
}
