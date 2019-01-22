package com.demo.test.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;


public class BeanE implements BeanFactoryPostProcessor{

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        try {
            BeanB beanB = (BeanB) beanFactory.getBean("beanB");
            System.out.println(beanB);
        }catch (Exception e){

        }
    }
}
