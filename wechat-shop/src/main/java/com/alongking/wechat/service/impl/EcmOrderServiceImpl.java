package com.alongking.wechat.service.impl;

import com.alongking.wechat.common.ShopConfig;
import com.alongking.wechat.dao.*;
import com.alongking.wechat.dto.OrderListDto;
import com.alongking.wechat.entity.*;
import com.alongking.wechat.service.IEcmOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


/**
 * Created by alongsea2 on 2017/1/31.
 */
@Service("iEcmOrderService")
public class EcmOrderServiceImpl implements IEcmOrderService {

    @Autowired
    private IEcmOrderDao iEcmOrderDao;

    @Autowired
    private IEcmGoodsDao iEcmGoodsDao;

    @Autowired
    private IEcmAddressDao iEcmAddressDao;

    @Autowired
    private IEcmPaymentDao iEcmPaymentDao;

    @Autowired
    private IEcmMemberDao iEcmMemberDao;

    @Transactional
    @Override
    public int saveOrder(int goodsId, String wechatId, int payment, int buyNum, int addressId) {
        EcmGoodsEntity goodsInfo = iEcmGoodsDao.selectGoodsInfo(0, goodsId);
        if(goodsInfo == null){
            return 2;
        }
        EcmAddressEntity address = iEcmAddressDao.getAddress(addressId);
        if(address == null){
            return 3;
        }
        EcmPaymentEntity paymentInfo = iEcmPaymentDao.selectPayment(payment);
        if(paymentInfo == null){
            return 4;
        }
        if(buyNum <= 0){
            return 5;
        }
        EcmMemberEntity member = iEcmMemberDao.selectUserByWechatId(wechatId);
        if(member == null){
            return 6;
        }

        int now = (int)(System.currentTimeMillis() / 1000);
        EcmOrderEntity ecmOrderEntity = new EcmOrderEntity();
        ecmOrderEntity.setAddTime(now);
        ecmOrderEntity.setAnonymous(0);
        ecmOrderEntity.setBuyerEmail("");
        ecmOrderEntity.setBuyerId(member.getUserId());
        ecmOrderEntity.setDiscount(new BigDecimal(0));
        ecmOrderEntity.setEvaluationTime(now);
        ecmOrderEntity.setBuyerName(member.getRealName());
        ecmOrderEntity.setOrderSn(UUID.randomUUID().toString().replace("-",""));
        ecmOrderEntity.setType("material");
        ecmOrderEntity.setExtension("normal");
        ecmOrderEntity.setSellerId(goodsInfo.getStoreId());
        ecmOrderEntity.setSellerName(iEcmMemberDao.selectUserById(goodsInfo.getStoreId()).getRealName());
        ecmOrderEntity.setStatus(paymentInfo.getPaymentCode().equals("cod") ? ShopConfig.ORDER_SUBMITTED : ShopConfig.ORDER_PENDING);
        ecmOrderEntity.setPaymentId(payment);
        ecmOrderEntity.setPaymentCode(paymentInfo.getPaymentCode());
        ecmOrderEntity.setPaymentName(paymentInfo.getPaymentName());
        ecmOrderEntity.setGoodsAmount(goodsInfo.getPrice());
        ecmOrderEntity.setOrderAmount(goodsInfo.getPrice().multiply(new BigDecimal(buyNum)));
        int orderId = iEcmOrderDao.saveOrder(ecmOrderEntity);
        EcmOrderExtmEntity ecmOrderExtmEntity = new EcmOrderExtmEntity();
        ecmOrderExtmEntity.setOrderId(orderId);
        ecmOrderExtmEntity.setConsignee(address.getConsignee());
        ecmOrderExtmEntity.setRegionId(address.getRegionId());
        ecmOrderExtmEntity.setRegionName(address.getRegionName());
        ecmOrderExtmEntity.setPhoneMob(address.getPhoneMob());
        ecmOrderExtmEntity.setPhoneTel(address.getPhoneTel());
        ecmOrderExtmEntity.setAddress(address.getAddress());
        iEcmOrderDao.saveOrderExtm(ecmOrderExtmEntity);
        EcmOrderGoodsEntity ecmOrderGoodsEntity = new EcmOrderGoodsEntity();
        ecmOrderGoodsEntity.setOrderId(orderId);
        ecmOrderGoodsEntity.setComment("");
        ecmOrderGoodsEntity.setCreditValue(0);
        ecmOrderGoodsEntity.setEvaluation(0);
        ecmOrderGoodsEntity.setGoodsId(goodsId);
        ecmOrderGoodsEntity.setSpecId(goodsInfo.getDefaultSpec());
        ecmOrderGoodsEntity.setSpecification("");
        ecmOrderGoodsEntity.setPrice(goodsInfo.getPrice());
        ecmOrderGoodsEntity.setQuantity(buyNum);
        ecmOrderGoodsEntity.setGoodsImage(goodsInfo.getDefaultImage());
        ecmOrderGoodsEntity.setGoodsName(goodsInfo.getGoodsName());
        iEcmOrderDao.saveOrderGoods(ecmOrderGoodsEntity);
        return 1;
    }

    @Override
    public List<OrderListDto> selectOrderList(int userId, int pageNo, int limit, int status) {
        return iEcmOrderDao.selectOrderList(userId, pageNo, limit, status);
    }
}
