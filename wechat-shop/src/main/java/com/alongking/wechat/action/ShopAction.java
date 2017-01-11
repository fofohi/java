package com.alongking.wechat.action;

import com.alongking.wechat.common.ShopConfig;
import com.alongking.wechat.entity.EcmMemberEntity;
import com.alongking.wechat.service.IEcMemberService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by dell on 2016/9/30.
 */
public class ShopAction extends BaseAction {

    private EcmMemberEntity ecmMemberEntity;

    @Autowired
    private IEcMemberService iEcMemberService;

    public String shopIndex(){
        ecmMemberEntity = iEcMemberService.selectUserById(1);
        System.out.println("=====>" + ecmMemberEntity);
        return "success";
    }


    public String dispatcher(){
        //todo 跳转
        System.out.println("dispatcher");
        return ShopConfig.SUCCESS;
    }

    public String consumerIndex(){

        return ShopConfig.SUCCESS;
    }

    public EcmMemberEntity getEcmMemberEntity() {
        return ecmMemberEntity;
    }

    public void setEcmMemberEntity(EcmMemberEntity ecmMemberEntity) {
        this.ecmMemberEntity = ecmMemberEntity;
    }
}
