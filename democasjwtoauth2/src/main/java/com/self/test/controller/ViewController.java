package com.self.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @RequestMapping(value = "/t",method = RequestMethod.GET)
    public String notFoundPage(){
        System.out.println(1);
        return "404.html";
    }

}
