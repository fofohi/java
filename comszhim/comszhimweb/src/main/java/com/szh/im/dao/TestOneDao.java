package com.szh.im.dao;

import com.szh.im.entity.TestOneTable;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by alongsea2 on 2017/3/14.
 */
@Component
public class TestOneDao implements TestOne /*extends Repository<TestOneTable,Integer>*/ {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private RedisTemplate<String, String> template;

    public boolean setLock() {
        return template.execute((RedisCallback<Boolean>) redisConnection -> redisConnection.setNX("lock".getBytes(), String.valueOf(System.currentTimeMillis()).getBytes()));
    }
    private void delLock(){
        template.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.del("lock".getBytes());
            }
        });
    }

    public void test(int x){
        boolean b = this.setLock();
        try {
            System.out.println(b + ":" + x);
            if(b){
                Session os = sessionFactory.openSession();
                TestOneTable r = (TestOneTable) os.createQuery("from TestOneTable WHERE id = ?").setParameter(0, 1).list().get(0);
                r.setFourId(r.getFourId() - x);
                Transaction o = os.getTransaction();
                o.begin();
                os.save(r);
                o.commit();
                os.close();
                List i = null;
                System.out.println(i.get(0));
                delLock();
            } else {
                System.out.println("下单失败");
            }
        }catch(Exception e){
            delLock();
        }


    }



}
