package com.szh.im.dao;
import com.szh.im.service.JumpConsistentHash;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by alongsea2 on 2017/3/14.
 */
//@Component
public class TestOneDao implements TestOne /*extends Repository<TestOneTable,Integer>*/ {

    @Autowired
    private SessionFactory sessionFactory;

    public static ExecutorService pool = Executors.newFixedThreadPool(20);

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
                    pool.execute(() -> {
                        Session os = sessionFactory.openSession();
                        Transaction tr = os.getTransaction();
                        tr.begin();
                        os.createNativeQuery(entry.getValue().substring(0, entry.getValue().lastIndexOf(","))).executeUpdate();
                        tr.commit();
                        os.close();
                    });
                }


            }).start();






        //NativeQuery r = os.createNativeQuery("select * from test_one_table where one_name -> '$.TEST' = \"test\"",TestOneTable.class);




    }



}
