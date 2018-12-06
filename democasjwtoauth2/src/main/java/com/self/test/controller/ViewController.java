package com.self.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ViewController {

    @RequestMapping(value = "/img",method = RequestMethod.GET)
    public String notFoundPage(HttpServletRequest request, HttpServletResponse response){

        System.out.println(1);
        return "404.html";
    }

}
