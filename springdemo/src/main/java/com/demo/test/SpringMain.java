package com.demo.test;

import com.demo.test.demo.BeanA;
import com.demo.test.demo.BeanB;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("service.xml");
        BeanA a = (BeanA) context.getBean("beanA");
        BeanB b = (BeanB) context.getBean("beanB");
        System.out.println(a.testA());
        System.out.println(b.getB());
    }


}
