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
    <div class="card-list">
        <s:iterator value="addressList" var="list">
            <div class="card">
                <div class="card-header">收件人:<s:property value="#list.consignee"/><div class="button button-danger" id="delAddress<s:property value="#list.addrId"/>" onclick="delAddress(this)">删除</div></div>
                <div class="card-content">
                    <div class="card-content-inner">地址:<s:property value="#list.regionName"/><s:property
                            value="#list.address"/></div>
                </div>
                <div class="card-footer">收件人联系电话:<s:property value="#list.phoneMob"/></div>
                <div class="card-footer">是否默认地址:
                    <div class="item-media"><i class="icon icon-form-toggle"></i></div>
                    <div class="item-inner">
                        <div class="item-input">
                            <label class="label-switch">
                                <input type="checkbox" onchange="checkDefault(this)"
                                       <s:if test="#list.isDefault == 1">checked</s:if>
                                       id="address<s:property value="#list.addrId"/>">
                                <div class="checkbox">

                                </div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </s:iterator>
    </div>
    <div style="width: 100%;text-align: center;" id="addAddress">
        <img src="css/img/plus.png" style="width: 10%" id="icon-img"/>
    </div>
</div>

<script>
    (function () {
        var wechatId = "<s:property value="wechatId"/>";
        var lock = false;
        var newAddress = ' <div class="card">' +
                '<div class="card-header">收件人:<input id="consignee" placeholder="请填写收件人"/></div>' +
                ' <div class="card-content">' +
                '<div class="card-content-inner">' +
                '省:<select id="selectProvince"><option>选择省份</option></select>' +
                '</div>' +
                '<div class="card-content-inner">' +
                '市:<select id="selectCity"><option>选择市</option></select>' +
                '</div>' +
                '<div class="card-content-inner">' +
                '详细地址:<input id="addressName"/>' +
                '</div>' +
                '</div>' +
                '<div class="card-footer">收件人联系电话:<input id="tel" placeholder="请填写收件人手机号码"/></div>' +
                '<div class="card-footer">是否默认地址: <div class="item-media"><i class="icon icon-form-toggle"></i></div><div class="item-inner"><div class="item-input"><label class="label-switch"><input type="checkbox" id="selectDefault"><div class="checkbox"></div></label></div> </div></div></div>'
            ;
        delAddress = function (o) {
            if(confirm("确定删除吗?")){
                var addressId = o.id.split("delAddress")[1];
                $.ajax({
                    type: "POST",
                    url: "delAddress",
                    data: {"addressId":addressId,"wechatId":wechatId},
                    success:function(ele){
                        $.toast(ele.message);
                        setTimeout(function () {
                            location.reload();
                        },1000);
                    }
                });
            }
        };

        checkDefault = function (o) {
            var checkBoxId = o.id.split("address")[1];
            var isDefault = o.checked == true ? 1 : 0;

            $.ajax({
                type: "POST",
                url: "defaultAddress",
                data: {"addressId":checkBoxId,"isDefault":isDefault,"wechatId":wechatId},
                success:function(){
                    $.toast("操作成功");
                    setTimeout(function () {
                        location.reload();
                    },1000);
                }
            });
        }

        $("#addAddress").click(function () {
            if (!lock) {
                $(".card-list").append(newAddress);
                $(this).attr("id","confirmAddress");
                $("#icon-img").attr("src","css/img/confirm.png");

                $.ajax({
                    type: "POST",
                    url: "region",
                    data: {"regionId":3418},
                    success:function(ele){
                        var provinceHtml = "";
                        for(var i = 0;i < ele["data"].length;i++){
                            provinceHtml += '<option value='+ele["data"][i].regionId+'>'+ele["data"][i].regionName+'</option>';
                        }
                        $("#selectProvince").append(provinceHtml);
                    }
                });

                $("#selectProvince").change(function () {
                    var provinceId = $("#selectProvince").val();
                    $.ajax({
                        type: "POST",
                        url: "region",
                        data: {"regionId":provinceId},
                        success:function(ele){
                            var cityHtml = "";
                            for(var i = 0;i < ele["data"].length;i++){
                                cityHtml += '<option value='+ele["data"][i].regionId+'>'+ele["data"][i].regionName+'</option>';
                            }
                            $("#selectCity").append(cityHtml);
                        }
                    })
                });

                $("#confirmAddress").click(function () {
                    var consignee = $("#consignee").val();
                    var selectProvince = $("#selectProvince").val();
                    var selectCity = $("#selectCity").val();
                    var addressName = $("#addressName").val();
                    var tel = $("#tel").val();
                    var selectDefault = $("#selectDefault").attr("checked") == true ? 1 : 0 ;

                    $.ajax({
                        type: "POST",
                        url: "addAddress",
                        data: {"consignee":consignee,"selectProvince":selectProvince,"selectCity":selectCity,"addressName":addressName,"tel":tel,"selectDefault":selectDefault,"wechatId":wechatId},
                        dataType: "json",
                        beforeSend: function () {
                            $("#icon-img").attr("src","css/img/ripple.gif");
                        },
                        success:function(ele){
                            $.toast(ele.message);
                        },
                        complete: function () {
                            setTimeout(function () {
                                location.reload();
                            },1000);
                        }
                    });
                });
                lock = true;
            }
        });
    })();

</script>
<jsp:include page="common/footer.jsp"/>

