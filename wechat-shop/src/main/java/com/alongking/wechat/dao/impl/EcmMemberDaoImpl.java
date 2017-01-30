package com.alongking.wechat.dao.impl;

import com.alongking.wechat.dao.IEcmMemberDao;
import com.alongking.wechat.entity.EcmGoodsEntity;
import com.alongking.wechat.entity.EcmMemberEntity;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Component("iEcmMemberDao")
public class EcmMemberDaoImpl extends BaseDaoImpl implements IEcmMemberDao {

    public EcmMemberEntity selectUserById(int id) {
        return hibernateTemplate.get(EcmMemberEntity.class,id);
    }

    @Override
    public EcmMemberEntity selectUserByWechatId(String wechatId) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(EcmMemberEntity.class);
        detachedCriteria.add(Restrictions.eq("userName",wechatId));
        List<EcmMemberEntity> data = (List<EcmMemberEntity>) hibernateTemplate.findByCriteria(detachedCriteria);
        return data == null || data.size() == 0 ? null : data.get(0);
    }

    @Override
    public void saveMember(EcmMemberEntity ecmMemberEntity) {
        hibernateTemplate.saveOrUpdate(ecmMemberEntity);
    }
}
