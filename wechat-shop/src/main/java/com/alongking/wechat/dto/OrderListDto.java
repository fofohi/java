package com.alongking.wechat.dto;


import javax.persistence.Basic;
import javax.persistence.Column;
import java.math.BigDecimal;

/**
 * Created by alongsea2 on 2017/2/7.
 */
public class OrderListDto {

    private String orderSn;
    private int status;
    private String paymentName;
    private int payTime;
    private int addTime;
    private BigDecimal orderAmount;
    private int goodsId;
    private String goodsName;
    private int quantity;
    private BigDecimal price;
    private String imageGoods;
    private String regionName;
    private String phoneMob;
    private BigDecimal shippingFee;
    private String address;
    private String consignee;

    //a.order_sn,a.status,a.payment_name,a.pay_time,a.add_time,a.order_amount,b.goods_id,b.goods_name,b.quantity,b.price,b.goods_image,c.region_name,c.phone_mob,c.shipping_fee,c.address,c.consignee

    @Basic
    @Column(name = "order_sn")
    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "pay_time")
    public int getPayTime() {
        return payTime;
    }

    public void setPayTime(int payTime) {
        this.payTime = payTime;
    }

    @Basic
    @Column(name = "add_time")
    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "order_amount")
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Basic
    @Column(name = "goods_id")
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "goods_name")
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "goods_image")
    public String getImageGoods() {
        return imageGoods;
    }

    public void setImageGoods(String imageGoods) {
        this.imageGoods = imageGoods;
    }

    @Basic
    @Column(name = "region_name")
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Basic
    @Column(name = "phone_mob")
    public String getPhoneMob() {
        return phoneMob;
    }

    public void setPhoneMob(String phoneMob) {
        this.phoneMob = phoneMob;
    }

    @Basic
    @Column(name = "shipping_fee")
    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "consignee")
    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    @Basic
    @Column(name = "payment_name")
    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }


    //===private function==//
    private String fixImageUrl(String oldImage){
        if(oldImage == null) return null;
        if(!oldImage.contains("http")){
            return "http://api.csfenshang.cc/" + oldImage;
        }else{
            return oldImage;
        }
    }
}
