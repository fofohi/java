package com.alongking.wechat.dao.impl;

import com.alongking.wechat.dao.IEcmMemberDao;
import com.alongking.wechat.entity.EcmMemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Component("iEcmMemberDao")
public class EcMemberDaoImpl implements IEcmMemberDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    public EcmMemberEntity selectUserById(int id) {
        return hibernateTemplate.get(EcmMemberEntity.class,id);
    }
}
