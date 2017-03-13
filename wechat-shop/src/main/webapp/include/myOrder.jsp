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
<nav class="bar bar-tab">
    <a class="tab-item" href="#">
        <span class="icon icon-home"></span>
        <span class="tab-label">首页</span>
    </a>
    <a class="tab-item" href="#">
        <span class="icon icon-me"></span>
        <span class="tab-label" id="myCenter">我</span>
    </a>
    <!--maybe购物车-->
</nav>

<div class="content" id="contents">
    <!-- 这里是页面内容区 -->

    <div id="orderList">
        <!--商品布局-->
        <div class="buttons-tab">
            <a href="#tab1" class="tab-link active button">全部</a>
            <%--<a href="#tab2" class="tab-link button">待付款</a>--%>
            <%--<a href="#tab3" class="tab-link button">待发货</a>--%>
        </div>
        <div class="tabs">
            <div id="tab1" class="tab active">
                <s:iterator value="orderList" var="goods">
                    <div class="card">
                        <div class="card-header">
                            <div>
                                <div>订单号:</div>
                                <s:property value="#goods.orderSn"/>
                            </div>
                        </div>
                        <div class="card-header">
                            <div>
                                <div>订单时间:</div>
                                <div class="timeFix"><s:property value="#goods.addTime"/></div>
                            </div>
                        </div>
                        <div class="card-content">
                            <div class="list-block media-list">
                                <ul>
                                    <li class="item-content">
                                        <div class="item-media">
                                            <img src="<s:property value="#goods.imageGoods"/> " width="100" height="100"/>
                                        </div>
                                        <div class="item-inner">
                                            <div style="color:#8f8f8f">商品名:<s:property value="#goods.goodsName"/> </div>
                                            <div style="color:#8f8f8f">商品总价:<s:property value="#goods.orderAmount"/></div>
                                            <div style="color:#8f8f8f">商品数量:<s:property value="#goods.quantity"/></div>
                                            <div style="color:#8f8f8f">收件人:<s:property value="#goods.consignee"/> </div>
                                            <div style="color:#8f8f8f">电话:<s:property value="#goods.phoneMob"/> </div>
                                            <div style="color:#8f8f8f">地址:<s:property value="#goods.address"/></div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="card-footer">
                            <div style="font-size: 20px">订单状态:</div>
                            <div style="font-size: 20px">
                                <s:if test="#goods.status == 10">
                                    <div>货到付款</div>
                                </s:if>
                                <s:elseif test="#goods.status == 11" >
                                    <div>等待付款</div>
                                </s:elseif>
                                <s:elseif test="#goods.status == 20">
                                    <div>等待发货</div>
                                </s:elseif>
                                <s:elseif test="#goods.status == 30">
                                    <div>已发货</div>
                                </s:elseif>
                                <s:elseif test="#goods.status == 40">
                                    <div>交易成功</div>
                                </s:elseif>
                                <s:elseif test="#goods.status == 0">
                                    <div>交易取消</div>
                                </s:elseif>
                            </div>
                        </div>
                    </div>
                </s:iterator>
            </div>
            <%--<div id="tab2" class="tab">--%>
                <%--<div class="content-block">--%>
                    <%--<p>This is tab 2 content</p>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div id="tab3" class="tab">--%>
                <%--<div class="content-block">--%>
                    <%--<p>This is tab 3 content</p>--%>
                <%--</div>--%>
            <%--</div>--%>
        </div>
    </div>
    <div id="loading" align="center" width="10%" style="display: none">
        <img src="css/img/ripple.gif" width="10%"/>
    </div>
    <script>
        var formatTime = function(timeStamp){
            var newDate = new Date();
            newDate.setTime(timeStamp);
            var year = newDate.getFullYear();
            var month = newDate.getMonth() + 1;
            var day   = newDate.getDate();
            var hour = newDate.getHours();
            var minutes = newDate.getMinutes();
            var seconds = newDate.getSeconds();
            return (year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":" + seconds);
        };
        (function () {
            $(".timeFix").each(function(index){
                var rawTime = $(this).text() * 1000;
                $(this).text(formatTime(rawTime));
            });
        })();
        var nextPage = 2;
        var contents = $("#contents");
        var wechatId = '<s:property value="wechatId" />';
        contents.bind("scroll", function () {
            es();
        });
        var f = function () {
            $.ajax({
                type: "GET",
                url: "order-json",
                data: {"pageNo": nextPage, "wechatId": wechatId},
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                beforeSend: function () {
                    $("#loading").show();
                },
                success: function (data) {
                    if (data != null && data.length != 0) {
                        nextPage++;
                        for (var i = 0; i < data.length; i++) {
                            var orderStatus;

                            if(data[i].status == 10){
                                orderStatus = '<div>货到付款</div>';
                            }else if(data[i].status == 11){
                                orderStatus = '<div>等待付款</div>';
                            }else if(data[i].status == 20){
                                orderStatus = '<div>等待发货</div>';
                            }else if(data[i].status == 30){
                                orderStatus = '<div>已发货</div>';
                            }else if(data[i].status == 40){
                                orderStatus = '<div>交易成功</div>';
                            }else if(data[i].status == 0){
                                orderStatus = '<div>交易取消</div>';
                            }

                            var appendData =
                                '<div class="card">' +
                                '<div class="card-header"><div><div>订单号:</div>'+data[i].orderSn+'</div></div>'+
                                '<div class="card-header"><div><div>订单时间:</div>'+formatTime(data[i].addTime * 1000)+'</div></div>'+
                                '<div class="card-content">' +
                                '<div class="list-block media-list">' +
                                '<ul>' +
                                '<li class="item-content">' +
                                '<div class="item-media"><img src="'+data[i].imageGoods+'" width="100" height="100"/></div>'+
                                '<div class="item-inner"><div style="color:#8f8f8f">商品名:'+data[i].goodsName+'</div><div style="color:#8f8f8f">商品总价:'+data[i].orderAmount+'</div><div style="color:#8f8f8f">商品数量:'+data[i].quantity+'</div> <div style="color:#8f8f8f">收件人:'+data[i].consignee+'</div><div style="color:#8f8f8f">电话:'+data[i].phoneMob+'</div><div style="color:#8f8f8f">地址:'+data[i].address+'</div></div>'+
                                '<li>' +
                                '</ul>' +
                                '<div class="card-footer">'+
                                '<div style="font-size: 20px">订单状态:</div>'+
                                '<div>'+orderStatus+'</div>'+
                                '</div>'+
                                '</div>' +
                                '</div>' +
                                '</div>';
                        }
                        $("#orderList").append(appendData);
                        contents.bind("scroll", es);
                    }
                },
                complete: function () {
                    $("#loading").hide();
                }
            });
        }
        var es = function () {
            var ch = contents.height();
            var cst = contents[0].scrollTop;
            var csh = contents[0].scrollHeight;
            console.log("cst" + cst + "|ch " + ch + "|csh" + csh)
            if ((contents[0].scrollTop + contents.height() + 1) >= contents[0].scrollHeight) {
                contents.unbind("scroll");
                f();
            }
        }
    </script>
</div>
<jsp:include page="common/footer.jsp"/>

