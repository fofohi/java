package com.alongking.wechat.service;

import com.alongking.wechat.entity.EcmGoodsEntity;

import java.util.List;

/**
 * Created by alongsea2 on 2017/1/13.
 */
public interface IEcmGoodsService {

    List<EcmGoodsEntity> selectGoods(int storeId, int pageNo, int offset);

    EcmGoodsEntity selectGoodsInfo(int storeId,int goodsId);
}
