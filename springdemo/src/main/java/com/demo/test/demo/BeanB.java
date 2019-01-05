package com.demo.test.demo;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BeanB{



    public String getB(){

        return "testB";
    }



}
