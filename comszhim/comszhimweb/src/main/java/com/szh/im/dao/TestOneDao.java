package com.szh.im.dao;

import com.szh.im.entity.TestOneTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by alongsea2 on 2017/3/14.
 */
@Component
public class TestOneDao implements TestOne /*extends Repository<TestOneTable,Integer>*/ {

    @Autowired
    private SessionFactory sessionFactory;

    public void test(int x){

        Session os = sessionFactory.getCurrentSession();
        NativeQuery r = os.createNativeQuery("select * from test_one_table where one_name -> '$.TEST' = \"test\"",TestOneTable.class);
        List<TestOneTable> list = (List<TestOneTable>) r.list();

        for (TestOneTable testOneTable : list) {
            System.out.println(testOneTable.getFourId());
        }

    }



}
