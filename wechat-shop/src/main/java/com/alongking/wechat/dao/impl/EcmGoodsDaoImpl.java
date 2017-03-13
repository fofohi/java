package com.alongking.wechat.dao.impl;

import com.alongking.wechat.dao.IEcmGoodsDao;
import com.alongking.wechat.entity.EcmGoodsEntity;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by alongsea2 on 2017/1/13.
 */
@Component("iEcmGoodsDao")
public class EcmGoodsDaoImpl extends BaseDaoImpl implements IEcmGoodsDao {

    @Override
    public List<EcmGoodsEntity> selectGoods(int storeId, int pageNo, int offset) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(EcmGoodsEntity.class);
        detachedCriteria.add(Restrictions.eq("storeId",storeId));
        detachedCriteria.addOrder(Order.desc("recommended"));
        return (List<EcmGoodsEntity>) hibernateTemplate.findByCriteria(detachedCriteria,pageNo,offset);
    }

    @Override
    public EcmGoodsEntity selectGoodsInfo(int storeId,int goodsId) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(EcmGoodsEntity.class);
        if(storeId != 0 ){
            detachedCriteria.add(Restrictions.eq("storeId",storeId));
        }
        detachedCriteria.add(Restrictions.eq("goodsId",goodsId));
        return (EcmGoodsEntity) hibernateTemplate.findByCriteria(detachedCriteria).get(0);
    }
}
