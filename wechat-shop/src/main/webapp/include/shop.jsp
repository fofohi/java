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
    <a class="tab-item active" href="#">
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

    <!-- 幻灯片 -->
    <div class="swiper-container">
        <div class="swiper-wrapper">
            <div class="swiper-slide"><img width="100%"
                                           src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i1/TB1n3rZHFXXXXX9XFXXXXXXXXXX_!!0-item_pic.jpg_320x320q60.jpg"
                                           alt=""></div>
            <div class="swiper-slide"><img width="100%"
                                           src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i4/TB10rkPGVXXXXXGapXXXXXXXXXX_!!0-item_pic.jpg_320x320q60.jpg"
                                           alt=""></div>
            <div class="swiper-slide"><img width="100%"
                                           src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i1/TB1kQI3HpXXXXbSXFXXXXXXXXXX_!!0-item_pic.jpg_320x320q60.jpg"
                                           alt=""></div>
        </div>
        <div class="swiper-pagination"></div>
        <div class="swiper-button-next"></div>
        <div class="swiper-button-prev"></div>
    </div>
    <script>
        $(function () {
            $(".swiper-container").swiper({
                pagination: '.swiper-pagination',
                nextButton: '.swiper-button-next',
                prevButton: '.swiper-button-prev',
                paginationClickable: true,
                spaceBetween: 30,
                centeredSlides: false,
                autoplay: 2500,
                autoplayDisableOnInteraction: false
            });
            $("#myCenter").click(function () {
                location.href = 'member?wechatId=<s:property value="wechatId" />';
            })
        });
    </script>
    <div id="productList">
        <!--商品布局-->
        <s:iterator value="lists" var="goods">
            <div class="card">
                <div valign="bottom" class="card-header color-white no-border no-padding">
                    <img class='card-cover' src="<s:property value="#goods.defaultImage"/>" alt="">
                </div>
                <div class="card-content">
                    <div class="card-content-inner">
                        <p class="color-gray"><s:property value="#goods.goodsName"/></p>
                        <p>售价<span style="float: right"><span class="color-danger"><s:property
                                value="#goods.price"/></span>元</span></p>
                    </div>
                </div>
                <div class="card-footer">
                    <a href="goodsInfo?goodsId=<s:property value="#goods.goodsId"/>&storeId=<s:property value="shopId"/>&wechatId=<s:property value="wechatId"/>" style="font-size:30px;margin: 0 auto" class="link">详情查看</a>
                </div>
            </div>
        </s:iterator>
    </div>
    <div id="loading" align="center" width="10%" style="display: none">
        <img src="css/img/ripple.gif" width="10%"/>
    </div>
    <script>
        var nextPage = 2;
        var contents = $("#contents");
        contents.bind("scroll", function () {
            es();
        });
        var f = function () {
            $.ajax({
                type: "GET",
                url: "index-json",
                data: {"pageNo": nextPage, "storeId": 2},
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                beforeSend: function () {
                   $("#loading").show();
                },
                success: function (data) {
                    if (data.length != 0) {
                        nextPage++;
                        for (var i = 0; i < data.length; i++) {
                            var appendData = '<div class="card">'
                                + '<div valign="bottom" class="card-header color-white no-border no-padding">'
                                + '<img class="card-cover" src=' + data[i].defaultImage + ' alt=""></div>'
                                + '<div class="card-content"><div class="card-content-inner"><p class="color-gray">' + data[i].goodsName + '</p>'
                                + '<p>售价<span style="float: right"><span class="color-danger">' + data[i].price + '</span>元</span></p></div>'
                                + '<div class="card-footer"><a href="goodsInfo?goodsId=' + data[i].goodsId + '&storeId='+data[i].storeId+'&wechatId=<s:property value="wechatId"/>" style= "font-size:30px;margin: 0 auto" class="link">详情查看</a></div>'
                                + '</div>';
                        }
                        $("#productList").append(appendData);
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

