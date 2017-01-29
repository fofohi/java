package com.alongking.wechat.service;

import com.alongking.wechat.entity.EcmAddressEntity;
import com.alongking.wechat.entity.EcmRegionEntity;

import java.util.List;

/**
 * Created by alongsea2 on 2017/1/26.
 */
public interface IEcmAddressService {

    EcmAddressEntity getMemberDefaultAddress(int userId, int isDefault);

    List<EcmAddressEntity> getMemberAddress(int userId);

    List<EcmRegionEntity> getRegionList(int parentId);

    int saveAddress(EcmAddressEntity ecmAddressEntity);

    void updateDefault(int addressId, int isDefault,int userId);

    void updateOtherNoneDefault(int userId);

    void delAddress(final int addressId, final int userId);

    EcmRegionEntity getRegionName(int regionId);
}
