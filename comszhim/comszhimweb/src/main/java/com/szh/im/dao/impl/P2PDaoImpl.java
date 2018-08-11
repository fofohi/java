package com.szh.im.dao.impl;

import com.szh.im.dao.P2PDao;
import com.szh.im.entity.GetP2p;
import com.szh.im.entity.GetP2pUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class P2PDaoImpl implements P2PDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<GetP2p> getP2PInvestPer(int userId) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from GetP2p where p2p_user_id = ?");
        query.setParameter(0,userId);

        return query.list();
    }

    @Override
    public GetP2pUser getP2PUser(int userId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from GetP2pUser where id = ?");
        query.setParameter(0,userId);
        return (GetP2pUser) query.list().get(0);
    }
}
