package com.szh.im.controller;

import com.szh.im.dao.TestOneDao;
import com.szh.im.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alongsea2 on 2017/3/14.
 */
@RestController
public class JpaController {

    private final UtilService utilService;

    private final TestOneDao testOneDao;

    @Autowired
    public JpaController(UtilService utilService, TestOneDao testOneDao) {
        this.utilService = utilService;
        this.testOneDao = testOneDao;
    }

    @RequestMapping(value = "/test")
    public void jpaTest(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                testOneDao.test(1);
            }
        }).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                testOneDao.test(2);
            }
        }).start();
    }

    @RequestMapping(value = "/testdubbo")
    public void dubboTest(){
        utilService.getProperty();
    }


}

