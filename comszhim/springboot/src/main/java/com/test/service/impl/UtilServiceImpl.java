package com.test.service.impl;

import com.test.service.UtilService;
import org.springframework.stereotype.Service;

@Service
public class UtilServiceImpl implements UtilService {


    @Override
    public String test(String code) {
        return code;
    }
}
