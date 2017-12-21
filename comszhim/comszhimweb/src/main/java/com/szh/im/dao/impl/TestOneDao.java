package com.szh.im.dao.impl;
import com.szh.im.dao.TestOne;
import com.szh.im.entity.TestFourTable;
import com.szh.im.common.JumpConsistentHash;
import com.szh.im.entity.TestOneTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


/**
 * Created by alongsea2 on 2017/3/14.
 */
@Component
public class TestOneDao implements TestOne /*extends Repository<TestOneTable,Integer>*/ {

    @Autowired
    private SessionFactory sessionFactory;



    public void test(int x){


        new Thread(()->{
            HashMap<String,String> map = new HashMap<>();


            for(int k = 0;k < 13;k++) {
                map.put(k+"","");

            }


//                    });
            for(int i = 250000 ;i<350000;i++){
                String uuid = UUID.randomUUID().toString();
                String s = "insert into jump_hash_test_%s (create_time,content,user_id)values";
                int index = JumpConsistentHash.jumpConsistentHash(i, 13);
                s = String.format(s,index);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if(entry.getKey().equals(index + "")){
                        String es = entry.getValue();
                        if(es.startsWith("insert")){
                            es +=  "(" + (System.currentTimeMillis() + i) + ",\"" + uuid.substring(0, 20) + "\"," + i + "),";
                        }else{
                            es += s + "(" + (System.currentTimeMillis() + i) + ",\"" + uuid.substring(0, 20) + "\"," + i + "),";
                        }
                        map.put(index + "",es);
                    }
                }
            }

            for (Map.Entry<String, String> entry : map.entrySet()) {

            }


        }).start();






        //NativeQuery r = os.createNativeQuery("select * from test_one_table where one_name -> '$.TEST' = \"test\"",TestOneTable.class);




    }

    @Override
    public TestOneTable getTestOneTable() {
        return sessionFactory.getCurrentSession().find(TestOneTable.class,1);
    }

    @Override
    public void testV2() {
        NativeQuery nativeQuery = sessionFactory.getCurrentSession().createNativeQuery("update test_one_table set one_name = one_name + 1 where id = 1");
        nativeQuery.executeUpdate();
    }


}
