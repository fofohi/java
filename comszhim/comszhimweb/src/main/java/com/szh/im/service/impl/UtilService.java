package com.szh.im.service.impl;

import com.szh.im.dao.impl.TestOneDao;
import com.szh.im.entity.TestOneTable;
import com.szh.im.service.GroovyService;
import com.szh.im.service.IUtilService;
import com.szh.im.service.TestOneService;
import com.szh.im.service.TestTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by alongsea2 on 2017/3/11.
 */
@Service
public class UtilService implements IUtilService {

    public static ExecutorService pool = Executors.newFixedThreadPool(20);

    @Autowired
    private TestOneService testOneService;

    @Autowired
    private TestTwoService testTwoService;

    @Autowired
    private GroovyService groovyService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void getProperty() {
        testV2();
        TestOneTable xx = testOneService.getTestOneTable();
        System.out.println("===> now is " + xx.getOneName());
        testV2();
    }

    @Override
    public void testV2() {
        testOneService.update();
    }
}