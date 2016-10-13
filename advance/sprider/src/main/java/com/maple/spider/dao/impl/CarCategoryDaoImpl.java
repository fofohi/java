package com.maple.spider.dao.impl;

import com.maple.spider.dao.CarCategoryDao;
import com.maple.spider.entity.hibernate.Test;
import com.maple.spider.entity.hibernate.Test2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 2016/10/13.
 */
@Component
public class CarCategoryDaoImpl implements CarCategoryDao {

    @Autowired
    SessionFactory hibernate;

    @Override
    public void testCase() {
        Test2 s3 = new Test2();
        s3.setTest("2");
        Session hibernateTemplate = hibernate.openSession();
        hibernateTemplate.save(s3);
        Test s2 = new Test();
        s2.setTest("fsd");
        hibernateTemplate.save(s2);
    }
}
