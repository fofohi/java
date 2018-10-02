package com.test.controller;


import com.test.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private UtilService utilService;


    @RequestMapping("/")
    String home() {
        return utilService.test("hello spring boot");
    }
}
