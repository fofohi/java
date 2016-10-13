package com.maple.spider;



import com.maple.spider.entity.hibernate.Test;
import com.maple.spider.service.CarCategoryService;
import org.apache.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by alongsea2 on 16/10/9.
 */
public class Spider {
    private static final Logger logger = Logger.getLogger(Spider.class);
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CarCategoryService bean = applicationContext.getBean(CarCategoryService.class);
        bean.buildCategoryJson();
    }
}
