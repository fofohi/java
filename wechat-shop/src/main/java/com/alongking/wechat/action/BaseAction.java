package com.alongking.wechat.action;

import com.alongking.wechat.common.ShopConfig;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by alongsea2 on 2017/1/11.
 */
public class BaseAction extends ActionSupport {

    private String title = ShopConfig.SHOP_TITLE;

    private int shopId;

    private String wechatId;

    private int orderStatus;

    protected HttpServletRequest getRequest(){
        return ServletActionContext.getRequest();
    }

    protected int getStoreId(){
        HttpServletRequest request = getRequest();
        shopId = Integer.parseInt(request.getParameter("storeId"));
        return shopId;
    }

    protected String getOpenId(){
        HttpServletRequest request = getRequest();
        wechatId = request.getParameter("wechatId");
        return wechatId;
    }

    protected int getPageNo(){
        HttpServletRequest request = getRequest();
        int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo"));
        return pageNo == 0 ? 1 : pageNo;
    }

    protected int getStatus(){
        HttpServletRequest request = getRequest();
        return getRequest().getParameter("orderStatus") == null ? -1 : Integer.parseInt(request.getParameter("orderStatus"));
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getWechatId() {
        return wechatId;
    }
}
