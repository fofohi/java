package com.alongking.wechat.dao;

import com.alongking.wechat.dto.OrderListDto;
import com.alongking.wechat.entity.EcmOrderEntity;
import com.alongking.wechat.entity.EcmOrderExtmEntity;
import com.alongking.wechat.entity.EcmOrderGoodsEntity;

import java.util.List;

/**
 * Created by alongsea2 on 2017/1/31.
 */
public interface IEcmOrderDao {

    int saveOrder(EcmOrderEntity ecmOrderEntity);

    void saveOrderExtm(EcmOrderExtmEntity orderExtmEntity);

    int saveOrderGoods(EcmOrderGoodsEntity orderGoodsEntity);

    List<OrderListDto> selectOrderList(int userId, int pageNo, int limit, int status);

}
