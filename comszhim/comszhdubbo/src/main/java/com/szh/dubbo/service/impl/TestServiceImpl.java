package com.szh.dubbo.service.impl;

import com.szh.dubbo.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by alongsea2 on 2017/3/23.
 */
@Service
public class TestServiceImpl implements TestService {
    public void test(){
        System.out.println("test...");
    }
}
