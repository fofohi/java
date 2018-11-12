package com.self.test.controller;


import com.self.cache.service.RedisCacheService;
import com.self.cache.util.SerializeUtils;
import com.self.test.pojo.Oauth2Pojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ApiController {

    @Autowired
    private RedisCacheService redisCacheService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    Object home(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().setAttribute("test","ssss");
        Oauth2Pojo oauth2Pojo = new Oauth2Pojo();
        oauth2Pojo.setAppId("self");
        oauth2Pojo.setSecretKey("qazwsxedcrfv223s");
        oauth2Pojo.setEncryptMethod("HS256");
        redisCacheService.set("self".getBytes(),SerializeUtils.serialize(oauth2Pojo,Oauth2Pojo.class));
        return oauth2Pojo;
    }




    @RequestMapping(value = "/getAccessToken",method = RequestMethod.POST)
    Object getAccessToken(@RequestParam(value = "appId") String appId,@RequestParam(value = "encryptSign") String encryptSign) {
        byte[] objBytes = redisCacheService.get(appId.getBytes());
        Oauth2Pojo oauth2Pojo = SerializeUtils.deSerialize(objBytes, Oauth2Pojo.class);






        return oauth2Pojo;
    }


    @RequestMapping(value = "/casLogin",method = RequestMethod.POST)
    Object adminCasLogin(@RequestParam(value = "appId") String appId,@RequestParam(value = "encryptSign") String encryptSign) {
        byte[] objBytes = redisCacheService.get(appId.getBytes());
        Oauth2Pojo oauth2Pojo = SerializeUtils.deSerialize(objBytes, Oauth2Pojo.class);

        if(StringUtils.isEmpty(oauth2Pojo.getAccessToken())){




        }



        return oauth2Pojo;
    }
}
