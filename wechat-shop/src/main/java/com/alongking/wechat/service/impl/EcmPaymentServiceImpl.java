package com.alongking.wechat.service.impl;

import com.alongking.wechat.dao.IEcmPaymentDao;
import com.alongking.wechat.entity.EcmPaymentEntity;
import com.alongking.wechat.service.IEcmPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alongsea2 on 2017/1/30.
 */
@Service("iEcmPaymentService")
public class EcmPaymentServiceImpl implements IEcmPaymentService {

    @Autowired
    private IEcmPaymentDao iEcmPaymentDao;

    @Override
    public List<EcmPaymentEntity> selectPaymentList(int storeId) {
        return iEcmPaymentDao.selectPaymentList(storeId);
    }
}
