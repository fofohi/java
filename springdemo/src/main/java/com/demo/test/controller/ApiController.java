package com.demo.test.controller;

import com.demo.test.demo.BeanA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a")
public class ApiController {

    @Autowired
    private BeanA beanA;


    @RequestMapping(value = "/api",method = RequestMethod.GET)
    public void test(){
        System.out.println(beanA);
    }
}
