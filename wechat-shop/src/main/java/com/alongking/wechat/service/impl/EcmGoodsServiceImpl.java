package com.alongking.wechat.service.impl;

import com.alongking.wechat.dao.IEcmGoodsDao;
import com.alongking.wechat.entity.EcmGoodsEntity;
import com.alongking.wechat.service.IEcmGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alongsea2 on 2017/1/13.
 */
@Service("iEcmGoodsService")
public class EcmGoodsServiceImpl implements IEcmGoodsService {

    @Autowired
    private IEcmGoodsDao iEcmGoodsDao;

    @Override
    public List<EcmGoodsEntity> selectGoods(int storeId, int pageNo, int offset) {
        List<EcmGoodsEntity> list = iEcmGoodsDao.selectGoods(storeId, pageNo, offset);
        for (EcmGoodsEntity ecmGoodsEntity : list) {
            fixImageUrl(ecmGoodsEntity);
        }
        return list;
    }

    @Override
    public EcmGoodsEntity selectGoodsInfo(int storeId, int goodsId) {
        return fixImageUrl(iEcmGoodsDao.selectGoodsInfo(storeId,goodsId));
    }


    //===private function==//
    private EcmGoodsEntity fixImageUrl(EcmGoodsEntity entity){
        if(entity == null) return null;
        String oldImage = entity.getDefaultImage();
        if(!oldImage.contains("http")){
            String newImage = "http://api.csfenshang.cc/" + oldImage;
            entity.setDefaultImage(newImage);
        }
        return entity;
    }
}
