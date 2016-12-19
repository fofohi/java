package com.maple.spider.test;

import com.maple.spider.entity.hibernate.Test2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by dell on 2016/10/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class SpiderTest{

    @Autowired
    ApplicationContext ctx;

    /*@Test
    public void junit1Test(){
        SessionFactory hibernate = (SessionFactory) ctx.getBean("hibernate");

        Session hibernateTemplate = hibernate.openSession();
        Test2 res =(Test2) hibernateTemplate.get(Test2.class,1);
        Assert.assertNull(res);
    }

    @Test
    public void junit2Test(){
        SessionFactory hibernate = (SessionFactory) ctx.getBean("hibernate");
        Session hibernateTemplate = hibernate.openSession();
        Test2 test2 = new Test2();
        test2.setTest("test");
        hibernateTemplate.save(test2);
        Assert.assertNotNull(test2);
    }*/
}
