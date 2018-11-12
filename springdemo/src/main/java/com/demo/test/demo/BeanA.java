package com.demo.test.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanA implements BeanFactoryPostProcessor,ApplicationContextAware {

    private ApplicationContext applicationContext;


    @Autowired
    private BeanB beanB;

    @Autowired
    private BeanD beanD;

    public String testA(){
        System.out.println(beanB);
        System.out.println(beanD);
        if(beanD != null){
            beanD.publishEvent(applicationContext);
        }
        return "testA";
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanD o = (BeanD) applicationContext.getBean("beanD");
        //o.publishEvent(applicationContext);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
