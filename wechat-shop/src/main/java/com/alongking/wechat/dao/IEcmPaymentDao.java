package com.alongking.wechat.dao;

import com.alongking.wechat.entity.EcmPaymentEntity;

import java.util.List;

/**
 * Created by alongsea2 on 2017/1/30.
 */
public interface IEcmPaymentDao {
    List<EcmPaymentEntity> selectPaymentList(int storeId);

    EcmPaymentEntity selectPayment(int paymentId);
}
