<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: alongsea2
  Date: 2017/1/16
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/head.jsp"/>
<style type="text/css">
    .buy_num {
        border: 1px solid #dbdbdb;
        line-height: 26px;
        overflow: hidden;
    }

    .buy_num em {
        display: block;
        height: 26px;
        width: 26px;
        float: left;
        color: #7A7979;
        border-right: 1px solid #dbdbdb;
        text-align: center;
        cursor: pointer;
    }

    .buy_num .num {
        display: block;
        float: left;
        text-align: center;
        width: 52px;
        font-style: normal;
        font-size: 14px;
        line-height: 24px;
        border: 0;
    }

    .buy_num em.add {
        float: right;
        border-right: 0;
        border-left: 1px solid #dbdbdb;
    }
</style>
<div class="content">
    <div class="card">
        <div valign="bottom" class="card-header color-white no-border no-padding" style="justify-content:center">
            <p style="font-size: 30px;text-align: center;color: #8f8f8f;"><s:property value="goods.goodsName"/></p>
        </div>
        <div valign="bottom" class="card-header color-white no-border no-padding">
            <img class='card-cover' src="<s:property value="goods.defaultImage"/>" alt="">
        </div>

        <div class="card-content">
            <div class="card-content-inner">
                <div class="content-padded" style="font-size: 26px">
                    <p><s:property value="goods.description" escapeHtml="false"/></p>
                </div>
                <p class="color-gray"><s:property value="goods.goodsName"/></p>
                <p style="font-size: 30px;color: #8f8f8f;">售价<span style="float: right"><span class="color-danger"
                                                                                              style="font-size: 30px"><s:property
                        value="goods.price"/></span>元</span></p>
            </div>
        </div>
        <div class="card-footer" style="text-align: center">
            <a href="#" class="link open-buy" style="font-size:30px;margin: 0 auto">点击购买<span
                    class="icon icon-cart"></span></a>
        </div>
        <!--buy popup-->
        <div class="popup popup-buy" style="bottom: 0;top: initial;">
            <p><a class="close-popup" style="float: right;margin-right: 10px;font-size: 15px">X</a></p>
            <div class="content-block">
                <div>
                    <div class="list-block">
                        <ul>
                            <li>
                                <div class="item-content">
                                    <div class="item-media"><i class="icon icon-form-name"></i></div>
                                    <div class="item-inner">
                                        <div class="item-title label" style="font-size: 20px">数量:</div>
                                        <div class="item-input">
                                            <div class="buy_num">
                                                <em class="decrease">-</em>
                                                <input type="text" id="buyNum" value="1" class="num button button-dark"
                                                       style="height: 27px;width: 64%" disabled/>
                                                <em class="add">+</em>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="item-content">
                                    <div class="item-media"><i class="icon icon-form-name"></i></div>
                                    <div class="item-inner">
                                        <div class="item-title label" style="font-size: 20px">总价：</div>
                                        <div class="item-input">
                                            <p style="text-align: center" class="button button-dark" id="total">
                                                <s:property value="goods.price"/>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <s:if test="member != null && address != null">
                                <li>
                                    <div class="item-content">
                                        <div class="item-media"><i class="icon icon-form-name"></i></div>
                                        <div class="item-inner">
                                            <div class="item-title label" style="font-size: 20px">
                                                <div>收件人:</div>
                                            </div>
                                            <div class="item-input">
                                                <p><s:property value="address.consignee"/></p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="item-content">
                                        <div class="item-media"><i class="icon icon-form-name"></i></div>
                                        <div class="item-inner">
                                            <div class="item-title label" style="font-size: 20px">
                                                <div>联系电话:</div>
                                            </div>
                                            <div class="item-input">
                                                <p><s:property value="address.phoneMob"/></p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="item-content">
                                        <div class="item-media"><i class="icon icon-form-name"></i></div>
                                        <div class="item-inner">
                                            <div class="item-title label" style="font-size: 20px">
                                                <div>地址:</div>
                                                <div style="font-size: 10px"><a
                                                        href="address?wechatId=<s:property value="wechatId"/>">添加或者更换地址</a>
                                                </div>
                                            </div>
                                            <div class="item-input">
                                                <p><s:property value="address.regionName"/><s:property
                                                        value="address.address"/></p>
                                            </div>
                                        </div>
                                    </div>
                                    <input type="hidden" id="addressId" value="<s:property value="address.addrId"/>">
                                </li>
                            </s:if>
                            <s:elseif test="member !=null && address == null">
                                <li>
                                    <div class="item-content">
                                        <div class="item-media"><i class="icon icon-form-name"></i></div>
                                        <div class="item-inner">
                                            <div class="item-title label" style="font-size: 20px">
                                                <div>默认地址:</div>
                                                <div style="font-size: 10px"><a
                                                        href="address?wechatId=<s:property value="wechatId"/>">添加或者更换地址</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </s:elseif>
                        </ul>
                        <ul>
                            <li>
                                <div class="item-content">
                                    <div class="item-media"><i class="icon icon-form-name"></i></div>
                                    <div class="item-inner">
                                        <div class="item-title label" style="font-size: 20px">
                                            <div>支付方式:</div>
                                        </div>
                                        <s:iterator value="paymentEntityList" var="lists">
                                            <div class="item-title label" style="font-size: 14px;">
                                                <div><s:property value="#lists.paymentName"/><input type="radio" name="payment" value="<s:property value="#lists.paymentId" />"/></div>
                                            </div>
                                        </s:iterator>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="content-block">
                        <div class="row">
                            <div class="col-100" style="text-align: center" id="subOrder"><a
                                    class="button button-big button-fill button-success">确认提交</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        var wechatId = "<s:property value="wechatId"/>";
        var toFixed = function (num, s) {
            var times = Math.pow(10, s)
            var des = num * times + 0.5
            des = parseInt(des, 10) / times
            return des + ''
        }
        var loadingHtml = '<img src="css/img/ripple.gif" width="20%"/>';
        var price = <s:property value="goods.price"/>;

        $(".open-buy").click(function () {
            $.popup('.popup-buy');
        });

        $(".add").click(function () {
            var n = $(this).prev().val();
            var num = parseInt(n) + 1;
            if (num == 0) {
                return;
            }
            $(this).prev().val(num);
            $("#total").text(toFixed(num * price, 2));
        });

        $(".decrease").click(function () {
            var n = $(this).next().val();
            var num = parseInt(n) - 1;
            if (num == 0) {
                return
            }
            $(this).next().val(num);
            $("#total").text(toFixed(num * price, 2));
        });

        $("#subOrder").click(function () {
            var addressId = $("#addressId").val();
            var buyNum = $("#buyNum").val();
            var payment = $("input[type='radio']:checked").val();
            var goodsId = "<s:property value="goods.goodsId"/>";
            var token = "<s:property value="sessionToken"/>";
            if(addressId == null ){
                $.toast("请先设置地址");
                return;
            }

            if(buyNum == null || buyNum == 0){
                $.toast("请选择购买数量");
                return;
            }

            if(payment == null){
                $.toast("请选择支付方式");
                return;
            }

            $.ajax({
                type: "POST",
                url: "subOrder",
                data: {"wechatId": wechatId,"addressId":addressId,"buyNum":buyNum,"payment":payment,"goodsId":goodsId,"subToken":token},
                dataType: "json",
                beforeSend: function () {
                    var subOrder = $("#subOrder");
                    subOrder.html(loadingHtml);
                    subOrder.unbind('click');
                },
                success: function (ele) {
                    $.toast(ele.message);
                    setTimeout(function () {
                        location.reload();//跳转url
                    }, 2000);
                }
            });
        });
    </script>
    <jsp:include page="common/footer.jsp"/>
