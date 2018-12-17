package com.demo.test.controller;

import com.demo.test.demo.BeanA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ApiController {

    @Autowired
    private BeanA beanA;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET,value = "/api")
    public Object test(){
        return beanA.testA();
    }
}
