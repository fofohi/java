package com.alongking.wechat.interceptor;

import com.alongking.wechat.common.ShopConfig;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by alongsea2 on 2017/1/25.
 */
public class LoginExceptionInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext actionContext = actionInvocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
        try {
            String wechatId = request.getParameter("wechatId");
            if(wechatId == null || wechatId.isEmpty()){
                return ShopConfig.REDIECT_WECHAT;
            }
        }catch (Exception e){
            return ShopConfig.REDIECT_WECHAT;
        }
        return actionInvocation.invoke();
    }
}
