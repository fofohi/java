package com.szh.im;

import com.szh.im.service.impl.UtilService;

import java.awt.*;

/**
 * Created by alongsea2 on 2017/3/11.
 *
 */
public class Application{

    public static void main(String[] args) throws AWTException {
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext(new String[] {"application-context.xml"});
//        UtilService service = context.getBean(UtilService.class);
        Robot robot = new Robot();
        robot.mouseMove(111,222);
    }
}
