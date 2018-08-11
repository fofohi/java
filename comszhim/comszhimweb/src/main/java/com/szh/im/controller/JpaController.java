package com.szh.im.controller;

import com.szh.im.service.GroovyService;
import com.szh.im.service.IUtilService;
import com.szh.im.service.P2PService;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alongsea2 on 2017/3/14.
 */
@RestController
public class JpaController implements ApplicationContextAware {

    //public static ExecutorService pool = Executors.newFixedThreadPool(20);

    private ApplicationContext applicationContext;

    @Autowired
    private IUtilService utilService;

    @Autowired
    private P2PService p2PService;

    @RequestMapping(value = "/test")
    public void jpaTest() {

        utilService.getProperty();


    }

    @RequestMapping(value = "/testdubbo")
    public void dubboTest() {

    }

    @RequestMapping(value = "/p2p", method = RequestMethod.GET)
    public void p2p(@RequestParam(value = "userId") int userId, HttpServletResponse httpResponse) {
        try {
            httpResponse.getWriter().write(p2PService.getP2P(userId));
            httpResponse.getWriter().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

