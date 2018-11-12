package com.demo.test.demo;


import org.springframework.beans.factory.annotation.Autowired;

public class BeanB {

    @Autowired
    private BeanD beanD;

    public String getB(){
        System.out.println(beanD);
        return "testB";
    }


}
