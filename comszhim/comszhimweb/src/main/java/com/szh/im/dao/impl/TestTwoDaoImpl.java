package com.szh.im.dao.impl;

import com.szh.im.dao.TestTwoDao;
import com.szh.im.entity.TestThreeTable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by alongsea2 on 2017/11/10.
 */
@Component
public class TestTwoDaoImpl implements TestTwoDao {


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void testTwo() {
        TestThreeTable testThreeTable = new TestThreeTable();
        testThreeTable.setThreeName(13131);
        sessionFactory.getCurrentSession().save(testThreeTable);
    }


}
