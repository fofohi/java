package com.alongking.wechat.dao.impl;

import com.alongking.wechat.dao.IEcmAddressDao;
import com.alongking.wechat.entity.EcmAddressEntity;
import com.alongking.wechat.entity.EcmRegionEntity;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;


/**
 * Created by alongsea2 on 2017/1/26.
 */
@Repository
public class EcmAddressDaoImpl extends BaseDaoImpl implements IEcmAddressDao{

    @Override
    public EcmAddressEntity getMemberDefaultAddress(int userId,int isDefault){
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(EcmAddressEntity.class);
        detachedCriteria.add(Restrictions.eq("userId",userId));
        detachedCriteria.add(Restrictions.eq("isDefault",isDefault));
        List<EcmAddressEntity> data = (List<EcmAddressEntity>) hibernateTemplate.findByCriteria(detachedCriteria);
        return data == null || data.size() == 0 ? null:data.get(0);
    }

    @Override
    public List<EcmAddressEntity> getMemberAddress(int userId){
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(EcmAddressEntity.class);
        detachedCriteria.add(Restrictions.eq("userId",userId));
        detachedCriteria.addOrder(Order.desc("isDefault"));
        return (List<EcmAddressEntity>) hibernateTemplate.findByCriteria(detachedCriteria);
    }

    @Override
    public List<EcmRegionEntity> getRegionList(int parentId) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(EcmRegionEntity.class);
        detachedCriteria.add(Restrictions.eq("parentId",parentId));
        return (List<EcmRegionEntity>) hibernateTemplate.findByCriteria(detachedCriteria);
    }

    @Override
    public int saveAddress(EcmAddressEntity ecmAddressEntity) {
        hibernateTemplate.save(ecmAddressEntity);
        return ecmAddressEntity.getAddrId();
    }

    @Override
    public void updateDefault(int addressId, int isDefault) {
        EcmAddressEntity entity = hibernateTemplate.get(EcmAddressEntity.class, addressId);
        entity.setIsDefault(isDefault);
        hibernateTemplate.save(entity);
    }

    @Override
    public void updateOtherNoneDefault(final int userId) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                String sql = "update ecm_address set is_default = 0 where user_id = :userId";
                SQLQuery query = session.createSQLQuery(sql);
                query.setInteger("userId",userId);
                query.executeUpdate();
                return null;
            }
        });
    }

    @Override
    public void delAddress(final int addressId, final int userId) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                String sql = "delete from ecm_address where addr_id = :addrId and user_id = :userId";
                SQLQuery query = session.createSQLQuery(sql);
                query.setInteger("userId",userId);
                query.setInteger("addrId",addressId);
                query.executeUpdate();
                return null;
            }
        });
    }

    @Override
    public EcmRegionEntity getRegionName(int regionId) {
        return hibernateTemplate.get(EcmRegionEntity.class,regionId);
    }

    @Override
    public int countAddressNum(final int userId) {
        return hibernateTemplate.execute(new HibernateCallback<Integer>() {
            @Override
            public Integer doInHibernate(Session session) throws HibernateException {
                String sql = "select count(*) from ecm_address where user_id = :userId";
                SQLQuery query = session.createSQLQuery(sql);
                query.setInteger("userId",userId);
                return ((BigInteger) query.uniqueResult()).intValue();
            }
        });
    }
}
