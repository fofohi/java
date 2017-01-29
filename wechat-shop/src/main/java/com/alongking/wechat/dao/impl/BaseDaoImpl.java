package com.alongking.wechat.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by alongsea2 on 2017/1/13.
 */
@Component
public class BaseDaoImpl {
    @Autowired
    protected HibernateTemplate hibernateTemplate;
}
