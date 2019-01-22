package com.demo.test.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;


@Service("beanA")
public class BeanA {

    @Autowired
    private BeanB beanB;

    @CrossOrigin
    public Object testA(){

        return beanB != null ? beanB.getB() : "ssss";
    }
}
