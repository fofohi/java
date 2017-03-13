package com.alongking.wechat.service;

import com.alongking.wechat.dto.OrderListDto;

import java.util.List;

/**
 * Created by alongsea2 on 2017/1/31.
 */

public interface IEcmOrderService {

    int saveOrder(int goodsId,String wechatId,int payment,int buyNum,int addressId);

    List<OrderListDto> selectOrderList(int userId, int pageNo, int limit, int status);

}
