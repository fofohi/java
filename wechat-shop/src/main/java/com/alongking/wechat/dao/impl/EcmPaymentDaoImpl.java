package com.alongking.wechat.dao.impl;

import com.alongking.wechat.dao.IEcmPaymentDao;
import com.alongking.wechat.entity.EcmGoodsEntity;
import com.alongking.wechat.entity.EcmPaymentEntity;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by alongsea2 on 2017/1/30.
 */
@Component("iEcmPaymentDao")
public class EcmPaymentDaoImpl extends BaseDaoImpl implements IEcmPaymentDao{

    @Override
    public List<EcmPaymentEntity> selectPaymentList(int storeId) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(EcmPaymentEntity.class);
        detachedCriteria.add(Restrictions.eq("storeId",storeId));
        detachedCriteria.add(Restrictions.eq("enabled",1));
        detachedCriteria.addOrder(Order.desc("sortOrder"));
        return (List<EcmPaymentEntity>) hibernateTemplate.findByCriteria(detachedCriteria);
    }

    @Override
    public EcmPaymentEntity selectPayment(int paymentId) {
        return hibernateTemplate.get(EcmPaymentEntity.class,paymentId);
    }
}
