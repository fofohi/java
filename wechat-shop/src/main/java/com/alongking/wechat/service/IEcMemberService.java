package com.alongking.wechat.service;

import com.alongking.wechat.entity.EcmMemberEntity;

/**
 * Created by alongsea2 on 2017/1/8.
 */
public interface IEcMemberService {

    EcmMemberEntity selectUserById(int id);

    EcmMemberEntity selectUserByWechatId(String wechatId);

    void saveMember(EcmMemberEntity ecmMemberEntity);
}
