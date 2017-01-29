package com.alongking.wechat.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by alongsea2 on 2017/1/15.
 *
 */
public class ExceptionInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        try {
            return actionInvocation.invoke();
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
}
