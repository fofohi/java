package com.alongking.wechat.interceptor;

import com.alongking.wechat.common.ShopConfig;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by alongsea2 on 2017/1/11.
 */
public class WechatUseInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext actionContext = actionInvocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
        String agent = request.getHeader("User-Agent");
        if(agent.contains("MicroMessenger")){//todo 微信内打开
            return ShopConfig.MUST_WECHAT;
        }else{
            return actionInvocation.invoke();
        }
    }
}
