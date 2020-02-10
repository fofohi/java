package com.demo.test.controller;

import com.demo.test.demo.BeanA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping
public class ApiController {

    @Autowired
    private BeanA beanA;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET,value = "/api")
    public Object test(){

        if(beanA == null){
            return "beanA is null";
        }
        return beanA.testA();
    }

    public static void main(String[] args) throws Exception {
        // >19 -10
        // <= 19 不减
        //>=3 先发往下翻-1个位置 然后再发移动位置计算
        //<3 直接发移动位置
        Robot r = new Robot();
        double x = 51 * 1.5;
        double y = 507*1.5;

        r.mouseWheel((int)(-4));
        Thread.sleep(100);
        r.mouseMove((int)x,(int)y);

    }
}
