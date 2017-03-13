package com.szh.im;

import com.szh.im.service.UtilService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by alongsea2 on 2017/3/11.
 *
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"application-context.xml"});
        UtilService service = context.getBean(UtilService.class);
    }
}
