<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2016/9/30
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="common/head.jsp"/>
<div class="content">
    <div class="card facebook-card">
        <div class="card-header no-border">
            <div class="facebook-avatar"><img
                    src="<s:property value="member.portrait"/>"
                    width="34" height="34"></div>
            <div class="facebook-name"><s:property value="member.realName"/></div>
        </div>
    </div>
    <div class="list-block">
        <ul>
            <a href="myOrder?wechatId=<s:property value="wechatId" />">
                <li class="item-content item-link">
                    <div class="item-media"><i class="icon icon-f7"></i></div>
                    <div class="item-inner">
                        <div class="item-title">我的订单</div>
                    </div>
                </li>
            </a>
            <a href="address?wechatId=<s:property value="wechatId" />">
                <li class="item-content item-link">
                    <div class="item-media"><i class="icon icon-f7"></i></div>
                    <div class="item-inner">
                        <div class="item-title">我的地址</div>
                    </div>
                </li>
            </a>
        </ul>
    </div>
</div>

<jsp:include page="common/footer.jsp"/>

