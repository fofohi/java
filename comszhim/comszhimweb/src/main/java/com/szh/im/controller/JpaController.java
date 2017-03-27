package com.szh.im.controller;

import com.szh.dubbo.service.TestService;
import com.szh.im.dao.TestOneDao;
import com.szh.im.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println(testOneDao);
    }

    @RequestMapping(value = "/testdubbo")
    public void dubboTest(){
        utilService.getProperty();
    }
}

