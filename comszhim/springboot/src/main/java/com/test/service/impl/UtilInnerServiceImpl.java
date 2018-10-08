package com.test.service.impl;

import com.cache.service.UtilService;
import com.test.service.UtilInnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilInnerServiceImpl implements UtilInnerService {

    @Autowired
    private UtilService utilService;


    @Override
    public String test(String code) {
        return utilService.test("hi custom spring starter");
    }
}
