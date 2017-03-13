package com.alongking.wechat.action;

import com.alongking.wechat.common.ShopConfig;
import com.alongking.wechat.dto.JsonResult;
import com.alongking.wechat.dto.OrderListDto;
import com.alongking.wechat.entity.*;
import com.alongking.wechat.service.*;
import com.alongking.wechat.util.HttpRequestUtil;
import com.alongking.wechat.util.SecurityUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Pattern;


/**
 * Created by dell on 2016/9/30.
 * 1.首页
 * 2.商品详情页 确认购买页面 购买数量 快递选择
 * 3.用户页 订单状态 地址编辑
 * 4.支付接口
 */
public class ShopAction extends BaseAction {

    private static final Logger logger = Logger.getLogger(ShopAction.class);

    private List<EcmGoodsEntity> lists;

    private EcmGoodsEntity goods;

    private EcmAddressEntity address;

    private List<EcmAddressEntity> addressList;

    private EcmMemberEntity member;

    private JsonResult jsonResult;

    private List<EcmPaymentEntity> paymentEntityList;

    private String sessionToken;

    private List<OrderListDto> orderList;

    @Autowired
    private IEcMemberService iEcMemberService;

    @Autowired
    private IEcmGoodsService iEcmGoodsService;

    @Autowired
    private IEcmAddressService iEcmAddressService;

    @Autowired
    private IEcmPaymentService iEcmPaymentService;

    @Autowired
    private IEcmOrderService iEcmOrderService;

    public String shopIndex() {
        getProductsLists(1);
        return ShopConfig.SUCCESS;
    }

    public String shopIndexJson() {
        int pageNo = getPageNo();
        getProductsLists(pageNo);
        return ShopConfig.SUCCESS;
    }

    public String goodsInfo() {
        setWechatId(getOpenId());
        member = iEcMemberService.selectUserByWechatId(getOpenId());
        if (member != null) {
            address = iEcmAddressService.getMemberDefaultAddress(member.getUserId(), 1);
        }
        int goodsId = Integer.parseInt(getRequest().getParameter("goodsId"));
        goods = iEcmGoodsService.selectGoodsInfo(getStoreId(), goodsId);
        paymentEntityList = iEcmPaymentService.selectPaymentList(getStoreId());
        sessionToken = SecurityUtil.MD5(System.currentTimeMillis() + "keyMd5");
        getRequest().getSession().setAttribute("subToken", sessionToken);
        return ShopConfig.SUCCESS;
    }

    public String authFromWechat() throws IOException {
        String redirectUrl = "http://www.csfenshang.cc/dispatcher";
        String oauthUrl = String.format(ShopConfig.OAUTH_URL, ShopConfig.APP_ID, URLEncoder.encode(redirectUrl, "utf-8"), getStoreId());
        logger.info(HttpRequestUtil.httpGet(oauthUrl).body().string());
        return ShopConfig.SUCCESS;
    }

    public String dispatcher() throws IOException {
        String storeId = getRequest().getParameter("state");
        String code = getRequest().getParameter("code");
        String tokenUrl = String.format(ShopConfig.TOKEN_URL, ShopConfig.APP_ID, ShopConfig.APP_SECRET, code);
        ObjectMapper objectMapper = new ObjectMapper();
        String tokenJson = HttpRequestUtil.httpGet(tokenUrl).body().string();
        JsonNode obj = objectMapper.readTree(tokenJson);
        logger.info("=====>" + tokenJson);

        setShopId(Integer.parseInt(storeId));
        String wechatId = obj.get("openid").asText();
        String accessToken = obj.get("access_token").asText();
        setWechatId(wechatId);
        logger.info("=====> openId" + wechatId);
        member = iEcMemberService.selectUserByWechatId(wechatId);
        int now = (int) (System.currentTimeMillis() / 1000);
        String getInfoUrl = String.format(ShopConfig.USER_INFO_URL,accessToken,wechatId);
        String userInfoJson = HttpRequestUtil.httpGet(getInfoUrl).body().string();
        JsonNode userObj = objectMapper.readTree(userInfoJson);
        if (member == null) {
            EcmMemberEntity memberEntity = new EcmMemberEntity();
            memberEntity.setUserName(wechatId);
            memberEntity.setPassword("d41d8cd98f00b204e9800998ecf8427e");
            memberEntity.setRealName(userObj.get("nickname").asText());
            memberEntity.setRegTime(now);
            memberEntity.setLastIp(getRequest().getRemoteHost());
            memberEntity.setLastLogin(now);
            memberEntity.setPortrait(userObj.get("headimgurl").asText());
            iEcMemberService.saveMember(memberEntity);
        } else {
            member.setLastIp(getRequest().getRemoteHost());
            member.setPortrait(userObj.get("headimgurl").asText());
            member.setLastLogin(now);
            iEcMemberService.saveMember(member);
        }
        return ShopConfig.SUCCESS;
    }

    public String consumerIndex() {
        setWechatId(getOpenId());
        member = iEcMemberService.selectUserByWechatId(getOpenId());
        return ShopConfig.SUCCESS;
    }

    public String subOrder() {
        setWechatId(getOpenId());
        HttpServletRequest request = getRequest();
        int addressId = Integer.parseInt(request.getParameter("addressId"));
        int goodsId = Integer.parseInt(request.getParameter("goodsId"));
        int buyNum = Integer.parseInt(request.getParameter("buyNum"));
        int payment = Integer.parseInt(request.getParameter("payment"));
        String token = request.getParameter("subToken");
        jsonResult = new JsonResult();
        if (!token.equals(request.getSession().getAttribute("subToken"))) {
            jsonResult.setCode(ShopConfig.FAIL_CODE);
            jsonResult.setMessage("会话已经过期,请刷新页面");
            return ShopConfig.SUCCESS;
        }

        int isOk = iEcmOrderService.saveOrder(goodsId, getOpenId(), payment, buyNum, addressId);
        if (isOk != 1) {
            jsonResult.setCode(ShopConfig.FAIL_CODE);
            jsonResult.setMessage("订单生成失败");
            return ShopConfig.SUCCESS;
        }
        request.getSession().setAttribute("subToken", null);
        jsonResult.setCode(ShopConfig.SUCCESS_CODE);
        jsonResult.setMessage("提交订单成功");
        return ShopConfig.SUCCESS;
    }

    public String address() {
        setWechatId(getOpenId());
        member = iEcMemberService.selectUserByWechatId(getOpenId());
        if (member != null) {
            addressList = iEcmAddressService.getMemberAddress(member.getUserId());
        }
        return ShopConfig.SUCCESS;
    }


    public String addAddressJson() {
        HttpServletRequest req = getRequest();
        setWechatId(getOpenId());
        member = iEcMemberService.selectUserByWechatId(getOpenId());
        jsonResult = new JsonResult();
        try {
            String consignee = req.getParameter("consignee");
            String addressName = req.getParameter("addressName");
            String tel = req.getParameter("tel");
            if (StringUtils.isEmpty(consignee) || StringUtils.isEmpty(addressName) || StringUtils.isEmpty(tel) || !Pattern.matches("\\d{11}", tel)) {
                throw new IllegalArgumentException();
            }
            int hasAddress = iEcmAddressService.countAddressNum(member.getUserId());
            if (hasAddress >= 3) {
                jsonResult.setCode(ShopConfig.FAIL_CODE);
                jsonResult.setMessage("地址最多保存3个");
                return ShopConfig.SUCCESS;
            }
            int selectCity = Integer.parseInt(req.getParameter("selectCity"));
            int selectProvince = Integer.parseInt(req.getParameter("selectProvince"));
            EcmRegionEntity provinceEntity = iEcmAddressService.getRegionName(selectProvince);
            int selectDefault = Integer.parseInt(req.getParameter("selectDefault"));
            EcmAddressEntity ecmAddressEntity = new EcmAddressEntity();
            ecmAddressEntity.setConsignee(consignee);
            ecmAddressEntity.setAddress(addressName);
            if (selectDefault == 1) {
                iEcmAddressService.updateOtherNoneDefault(member.getUserId());
            }
            ecmAddressEntity.setIsDefault(selectDefault);
            ecmAddressEntity.setPhoneMob(tel);
            ecmAddressEntity.setPhoneTel(tel);
            ecmAddressEntity.setRegionId(selectCity);
            EcmRegionEntity regionData = iEcmAddressService.getRegionName(selectCity);
            ecmAddressEntity.setRegionName(provinceEntity.getRegionName() + " " + regionData.getRegionName());
            ecmAddressEntity.setZipcode("0");
            ecmAddressEntity.setUserId(member.getUserId());
            iEcmAddressService.saveAddress(ecmAddressEntity);
        } catch (Exception e) {
            jsonResult.setCode(ShopConfig.FAIL_CODE);
            jsonResult.setMessage("请填写正确参数");
            logger.error("=====> addAddressJson error", e);
            return ShopConfig.SUCCESS;
        }
        jsonResult.setCode(ShopConfig.SUCCESS_CODE);
        jsonResult.setMessage("添加地址成功");
        return ShopConfig.SUCCESS;
    }

    public String delAddressJson() {
        setWechatId(getOpenId());
        member = iEcMemberService.selectUserByWechatId(getOpenId());
        jsonResult = new JsonResult();
        int addressId = Integer.parseInt(getRequest().getParameter("addressId"));
        if (member != null) {
            jsonResult.setCode(ShopConfig.SUCCESS_CODE);
            jsonResult.setMessage("删除地址成功");
            iEcmAddressService.delAddress(addressId, member.getUserId());
        } else {
            jsonResult.setCode(ShopConfig.FAIL_CODE);
            jsonResult.setMessage("删除地址失败");
        }
        return ShopConfig.SUCCESS;
    }

    public String defaultAddressJson() {
        setWechatId(getOpenId());
        member = iEcMemberService.selectUserByWechatId(getOpenId());
        if (member != null) {
            int addressId = Integer.parseInt(getRequest().getParameter("addressId"));
            int isDefault = Integer.parseInt(getRequest().getParameter("isDefault")) == 0 ? 0 : 1;
            iEcmAddressService.updateDefault(addressId, isDefault, member.getUserId());
            jsonResult = new JsonResult();
            jsonResult.setCode(ShopConfig.SUCCESS_CODE);
            jsonResult.setMessage(ShopConfig.STATUS_YES);
        }
        return ShopConfig.SUCCESS;
    }

    public String getRegion() {
        int regionId = Integer.parseInt(getRequest().getParameter("regionId"));

        List<EcmRegionEntity> regionList = iEcmAddressService.getRegionList(regionId);
        jsonResult = new JsonResult();
        if (regionList != null && regionList.size() > 0) {
            jsonResult.setData(regionList);
            jsonResult.setCode(ShopConfig.SUCCESS_CODE);
            jsonResult.setMessage(ShopConfig.STATUS_YES);
        } else {
            jsonResult.setCode(ShopConfig.FAIL_CODE);
            jsonResult.setMessage(ShopConfig.STATUS_NO);
        }
        return ShopConfig.SUCCESS;
    }

    public String getMemberOrder(){
        getOrderLists(1);
        return ShopConfig.SUCCESS;
    }

    public String getMemberOrderJson(){
        int pageNo = getPageNo();
        getOrderLists(pageNo);
        return ShopConfig.SUCCESS;
    }


    //=========private ===============
    private void getProductsLists(int pageNo) {
        setShopId(getStoreId());
        setWechatId(getOpenId());
        lists = iEcmGoodsService.selectGoods(getShopId(), (pageNo - 1) * ShopConfig.PAGE_LIMIT, ShopConfig.PAGE_LIMIT);
    }

    private void getOrderLists(int pageNo) {
        setWechatId(getOpenId());
        int status = getStatus();
        member = iEcMemberService.selectUserByWechatId(getOpenId());
        orderList = iEcmOrderService.selectOrderList(4/*member.getUserId()*/,(pageNo - 1) * ShopConfig.PAGE_LIMIT,ShopConfig.PAGE_LIMIT,status);
    }

    //=====get set====================


    public EcmAddressEntity getAddress() {
        return address;
    }

    public void setAddress(EcmAddressEntity address) {
        this.address = address;
    }

    public List<EcmGoodsEntity> getLists() {
        return lists;
    }

    public void setLists(List<EcmGoodsEntity> lists) {
        this.lists = lists;
    }

    public EcmGoodsEntity getGoods() {
        return goods;
    }

    public void setGoods(EcmGoodsEntity goods) {
        this.goods = goods;
    }

    public EcmMemberEntity getMember() {
        return member;
    }

    public void setMember(EcmMemberEntity member) {
        this.member = member;
    }

    public List<EcmAddressEntity> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<EcmAddressEntity> addressList) {
        this.addressList = addressList;
    }

    public JsonResult getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(JsonResult jsonResult) {
        this.jsonResult = jsonResult;
    }

    public List<EcmPaymentEntity> getPaymentEntityList() {
        return paymentEntityList;
    }

    public void setPaymentEntityList(List<EcmPaymentEntity> paymentEntityList) {
        this.paymentEntityList = paymentEntityList;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public List<OrderListDto> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListDto> orderList) {
        this.orderList = orderList;
    }
}
