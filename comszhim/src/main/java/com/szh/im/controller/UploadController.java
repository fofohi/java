package com.szh.im.controller;

import com.szh.im.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by dell on 2017/3/13.
 */
@RestController
public class UploadController {

    @RequestMapping(value = "/upload")
    public void uploadFile(HttpServletRequest req) {
        try {
            ServletInputStream in = req.getInputStream();
            int n;
            byte[] bt = new byte[1024];
            StringBuilder sb = new StringBuilder();
            while ( ( n = in.read()) != -1 ){

            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }
}
