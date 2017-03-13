package com.alongking.wechat.dao.impl;

import com.alongking.wechat.dao.IEcmOrderDao;
import com.alongking.wechat.dto.OrderListDto;
import com.alongking.wechat.entity.EcmGoodsEntity;
import com.alongking.wechat.entity.EcmOrderEntity;
import com.alongking.wechat.entity.EcmOrderExtmEntity;
import com.alongking.wechat.entity.EcmOrderGoodsEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by alongsea2 on 2017/1/31.
 */
@Component("iEcmOrderDao")
public class EcmOrderDaoImpl extends BaseDaoImpl implements IEcmOrderDao{

    @Override
    public int saveOrder(EcmOrderEntity ecmOrderEntity) {
        hibernateTemplate.save(ecmOrderEntity);
        hibernateTemplate.flush();
        ecmOrderEntity = hibernateTemplate.findByExample(ecmOrderEntity).get(0);
        return ecmOrderEntity.getOrderId();
    }

    @Override
    public void saveOrderExtm(EcmOrderExtmEntity orderExtmEntity) {
        hibernateTemplate.save(orderExtmEntity);
    }

    @Override
    public int saveOrderGoods(EcmOrderGoodsEntity orderGoodsEntity) {
        hibernateTemplate.save(orderGoodsEntity);
        return orderGoodsEntity.getRecId();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderListDto> selectOrderList(final int userId, final int pageNo, final int offset, final int status) {
        return (List<OrderListDto>) hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException {
                String sql = "select a.order_sn as orderSn,a.status,a.payment_name as paymentName,a.pay_time as payTime,a.add_time as addTime,a.order_amount as orderAmount,b.goods_id as goodsId,b.goods_name as goodsName,b.quantity,b.price,b.goods_image as imageGoods,c.region_name as regionName,c.phone_mob as phoneMob,c.shipping_fee as shippingFee,c.address,c.consignee from ecm_order a inner join ecm_order_goods b on a.order_id = b.order_id inner join ecm_order_extm c on a.order_id = c.order_id where a.buyer_id = :userId";
                if (status >= 0) {
                    sql += " and status = :status";
                }
                sql += " order by a.add_time desc limit :pageNo,:offset";
                Query query = session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(OrderListDto.class));
                query.setInteger("userId", userId);
                query.setInteger("pageNo",pageNo);
                query.setInteger("offset",offset);
                if (status >= 0) {
                    query.setInteger("status", status);
                }
                List r = query.list();
                return r == null || r.size() == 0 ? null : r;
            }
        });
    }
}