package com.alongking.wechat.service.impl;

import com.alongking.wechat.dao.IEcmAddressDao;
import com.alongking.wechat.entity.EcmAddressEntity;
import com.alongking.wechat.entity.EcmRegionEntity;
import com.alongking.wechat.service.IEcmAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alongsea2 on 2017/1/26.
 */
@Service("iEcmAddressService")
public class EcmAddressServiceImpl implements IEcmAddressService{

    @Autowired
    private IEcmAddressDao iEcmAddressDao;


    @Override
    public EcmAddressEntity getMemberDefaultAddress(int userId, int isDefault) {
        return iEcmAddressDao.getMemberDefaultAddress(userId,isDefault);
    }

    @Override
    public List<EcmAddressEntity> getMemberAddress(int userId){
        return iEcmAddressDao.getMemberAddress(userId);
    }

    @Override
    public List<EcmRegionEntity> getRegionList(int parentId) {
        return iEcmAddressDao.getRegionList(parentId);
    }

    @Override
    public int saveAddress(EcmAddressEntity ecmAddressEntity) {
        return iEcmAddressDao.saveAddress(ecmAddressEntity);
    }

    @Override
    public void updateDefault(int addressId, int isDefault,int userId) {
        iEcmAddressDao.updateOtherNoneDefault(userId);
        iEcmAddressDao.updateDefault(addressId,isDefault);
    }

    @Override
    public void updateOtherNoneDefault(int userId) {
        iEcmAddressDao.updateOtherNoneDefault(userId);
    }

    @Override
    public void delAddress(int addressId, int userId) {
        iEcmAddressDao.delAddress(addressId,userId);
    }

    @Override
    public EcmRegionEntity getRegionName(int regionId) {
        return iEcmAddressDao.getRegionName(regionId);
    }

    @Override
    public int countAddressNum(int userId) {
        return iEcmAddressDao.countAddressNum(userId);
    }
}
