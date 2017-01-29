<%@ page import="static org.apache.struts2.ServletActionContext.getRequest" %>
<%@ page import="com.alongking.wechat.common.ShopConfig" %><%--
  Created by IntelliJ IDEA.
  User: alongsea2
  Date: 2017/1/11
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String redirectUrl = "http://" + getRequest().getLocalName() + "?storeId=" + ShopConfig.STORE_ID;
    response.sendRedirect(redirectUrl);
%>


