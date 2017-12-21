package com.szh.im.service.impl;

import com.szh.im.dao.TestTwoDao;
import com.szh.im.service.TestTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alongsea2 on 2017/11/10.
 */
@Service
public class TestTwoServiceImpl implements TestTwoService {

    @Autowired
    private TestTwoDao testTwoDao;

    @Transactional
    @Override
    public void testTwo() {
        testTwoDao.testTwo();
    }
}
