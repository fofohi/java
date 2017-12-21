package com.szh.im.controller;

import com.szh.im.service.GroovyService;
import com.szh.im.service.IUtilService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alongsea2 on 2017/3/14.
 */
@RestController
public class JpaController implements ApplicationContextAware{

    //public static ExecutorService pool = Executors.newFixedThreadPool(20);

    private ApplicationContext applicationContext;

    @Autowired
    private IUtilService utilService;

    @RequestMapping(value = "/test")
    public void jpaTest(){

            utilService.getProperty();


    }

    @RequestMapping(value = "/testdubbo")
    public void dubboTest(){
        GroovyService s = applicationContext.getBean("groovyService", GroovyService.class);
        s.test();
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

