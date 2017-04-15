package com.szh.im.controller;

import com.szh.im.dao.TestOneDao;
import com.szh.im.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
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
        testOneDao.test();
    }

    @RequestMapping(value = "/testdubbo")
    public void dubboTest(){
        utilService.getProperty();
    }

    public static void main(String[] args) {
        String s = "^\\d+\\.\\d{1,2}$|^\\d+$";
        String b = "1.2";
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(b);
        System.out.println(matcher.find());
    }
}

