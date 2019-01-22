package com.self.test.bean;

import com.self.apollo.util.ApolloPropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class CasFilter implements Filter {

    @Autowired
    private ApolloPropertiesUtil apolloPropertiesUtil;

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取配置的 不需要过滤的url
        System.out.println(apolloPropertiesUtil.getProperties("match.url"));
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        System.out.println(session.getAttribute("test"));
        //看看是否有ticket 有的话验证ticket
        //没有的话就要跳转登录页面
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.sendRedirect("/t?123");
        //filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
