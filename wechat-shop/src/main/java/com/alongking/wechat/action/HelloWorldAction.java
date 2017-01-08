package com.alongking.wechat.action;

import com.alongking.wechat.entity.EcmMemberEntity;
import com.alongking.wechat.service.IEcMemberService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 2016/9/30.
 */
@Component
@Scope("prototype")
public class HelloWorldAction extends ActionSupport {

    private EcmMemberEntity ecmMemberEntity;

    @Autowired
    private IEcMemberService iEcMemberService;


    public String test(){
        System.out.println("=====>" + iEcMemberService);
//        ecmMemberEntity = iEcMemberService.selectUserById(1);
//        System.out.println(ecmMemberEntity);
        return "success";
    }

    public EcmMemberEntity getEcmMemberEntity() {
        return ecmMemberEntity;
    }

    public void setEcmMemberEntity(EcmMemberEntity ecmMemberEntity) {
        this.ecmMemberEntity = ecmMemberEntity;
    }
}
