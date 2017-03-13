package com.alongking.wechat.service;

import com.alongking.wechat.entity.EcmPaymentEntity;

import java.util.List;

/**
 * Created by alongsea2 on 2017/1/30.
 */
public interface IEcmPaymentService {

    List<EcmPaymentEntity> selectPaymentList(int storeId);
}
