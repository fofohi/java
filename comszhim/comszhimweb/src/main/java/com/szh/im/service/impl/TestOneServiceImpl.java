package com.szh.im.service.impl;

import com.szh.im.dao.impl.TestOneDao;
import com.szh.im.entity.TestOneTable;
import com.szh.im.service.TestOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alongsea2 on 2017/12/20.
 */
@Service
public class TestOneServiceImpl implements TestOneService {

    @Autowired
    private TestOneDao testOneDao;

    @Transactional
    @Override
    public void update() {
        testOneDao.testV2();
    }

    @Transactional
    @Override
    public TestOneTable getTestOneTable() {
        return testOneDao.getTestOneTable();
    }
}

