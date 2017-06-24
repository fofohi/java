package com.szh.im.service;

import com.szh.im.dao.TestOneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by alongsea2 on 2017/3/11.
 */
@Service
public class UtilService implements IUtilService{

    @Autowired
    private TestOneDao testService;

    @Transactional(rollbackFor = Exception.class)
    public void getProperty() {

       testService.test(1);

    }
}