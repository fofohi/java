package com.self.test.controller;


import com.self.cache.service.RedisCacheService;
import com.self.cache.util.SerializeUtils;
import com.self.test.bean.FtpUploadUtil;
import com.self.test.pojo.Oauth2Pojo;
import okhttp3.*;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
public class ApiController {

    @Autowired
    private FTPClient client;

    @Autowired
    private RedisCacheService redisCacheService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    Object home(HttpServletRequest httpServletRequest) throws IOException {
        httpServletRequest.getSession().setAttribute("test","ssss");
        Oauth2Pojo oauth2Pojo = new Oauth2Pojo();
        oauth2Pojo.setAppId("self");
        oauth2Pojo.setSecretKey("qazwsxedcrfv223s");
        oauth2Pojo.setEncryptMethod("HS256");
        redisCacheService.set("self".getBytes(),SerializeUtils.serialize(oauth2Pojo,Oauth2Pojo.class));

        return oauth2Pojo;
    }




    @RequestMapping(value = "/getAccessToken",method = RequestMethod.POST)
    Object getAccessToken(HttpServletRequest  request) {
       /* byte[] objBytes = redisCacheService.get(appId.getBytes());
        Oauth2Pojo oauth2Pojo = SerializeUtils.deSerialize(objBytes, Oauth2Pojo.class);*/

        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
            for (Map.Entry<String, MultipartFile> stringMultipartFileEntry : fileMap.entrySet()) {
                System.out.println(stringMultipartFileEntry.getKey());
                client.setFileType(FTPClient.BINARY_FILE_TYPE);
                client.mkd("/test12");
                client.storeFile("/test12/" + stringMultipartFileEntry.getKey(), multipartRequest.getFile(stringMultipartFileEntry.getKey()).getInputStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                client.connect("localhost",2121);
                System.out.println(client.login("admin", "123456"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        /*System.out.println(multipartRequest.getFile("pic").getContentType());


            client.setFileType(FTPClient.BINARY_FILE_TYPE);
            client.storeFile("xxx.jpg", multipartRequest.getFile("pic").getInputStream());

        } catch (Exception e) {
            try {
                client.connect("localhost",2121);
                client.login("admin","123456");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }*/

        return null;
    }


    @RequestMapping(value = "/test2",method = RequestMethod.POST)
    Object getAccessToken2(HttpServletRequest request) {
        OkHttpClient builderClient = new OkHttpClient();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        FtpUploadUtil.uploadImgToFtpServer(fileMap,"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ4eGRkIiwic3ViIjoibHNtIiwidXNlcklkIjo2Miwicm9sZSI6MiwianRpIjoiMTk2MDQyYjUtZjJkNS00NTY0LTlmM2EtZmU2OTI4NjcwMjg2In0.2slqubp_H8p88ld7iHM18M-KiXrFd5S-Syx7tRfrmh8",0);

        return null;
    }
}
