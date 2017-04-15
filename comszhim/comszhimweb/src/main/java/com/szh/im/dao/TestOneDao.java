package com.szh.im.dao;

import com.szh.im.entity.TestOneTable;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by alongsea2 on 2017/3/14.
 */
@Component
public class TestOneDao implements TestOne /*extends Repository<TestOneTable,Integer>*/ {

    @Autowired
    private SessionFactory sessionFactory;

    public void test(){
        //System.out.println(sessionFactory.openSession().createQuery("from TestOneTable WHERE id = 1").list());
        TestOneTable testOneTable = new TestOneTable();
        testOneTable.setFourId(100);
        testOneTable.setOneName(101);
        Session os = sessionFactory.openSession();
        Transaction o = os.getTransaction();
        o.begin();
        os.save(testOneTable);
        o.commit();
        os.close();
    }



}
