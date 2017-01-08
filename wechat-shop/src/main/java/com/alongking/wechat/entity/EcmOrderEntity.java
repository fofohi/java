package com.alongking.wechat.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_order", schema = "fenshang", catalog = "")
public class EcmOrderEntity {
    private int orderId;
    private String orderSn;
    private String type;
    private String extension;
    private int sellerId;
    private String sellerName;
    private int buyerId;
    private String buyerName;
    private String buyerEmail;
    private byte status;
    private int addTime;
    private Integer paymentId;
    private String paymentName;
    private String paymentCode;
    private String outTradeSn;
    private Integer payTime;
    private String payMessage;
    private Integer shipTime;
    private String invoiceNo;
    private int finishedTime;
    private BigDecimal goodsAmount;
    private BigDecimal discount;
    private BigDecimal orderAmount;
    private byte evaluationStatus;
    private int evaluationTime;
    private byte anonymous;
    private String postscript;
    private byte payAlter;

    @Id
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "order_sn", nullable = false, length = 20)
    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 10)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "extension", nullable = false, length = 10)
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Basic
    @Column(name = "seller_id", nullable = false)
    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    @Basic
    @Column(name = "seller_name", nullable = true, length = 100)
    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Basic
    @Column(name = "buyer_id", nullable = false)
    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    @Basic
    @Column(name = "buyer_name", nullable = true, length = 100)
    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    @Basic
    @Column(name = "buyer_email", nullable = false, length = 60)
    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "add_time", nullable = false)
    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "payment_id", nullable = true)
    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    @Basic
    @Column(name = "payment_name", nullable = true, length = 100)
    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    @Basic
    @Column(name = "payment_code", nullable = false, length = 20)
    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    @Basic
    @Column(name = "out_trade_sn", nullable = false, length = 20)
    public String getOutTradeSn() {
        return outTradeSn;
    }

    public void setOutTradeSn(String outTradeSn) {
        this.outTradeSn = outTradeSn;
    }

    @Basic
    @Column(name = "pay_time", nullable = true)
    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    @Basic
    @Column(name = "pay_message", nullable = false, length = 255)
    public String getPayMessage() {
        return payMessage;
    }

    public void setPayMessage(String payMessage) {
        this.payMessage = payMessage;
    }

    @Basic
    @Column(name = "ship_time", nullable = true)
    public Integer getShipTime() {
        return shipTime;
    }

    public void setShipTime(Integer shipTime) {
        this.shipTime = shipTime;
    }

    @Basic
    @Column(name = "invoice_no", nullable = true, length = 255)
    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    @Basic
    @Column(name = "finished_time", nullable = false)
    public int getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(int finishedTime) {
        this.finishedTime = finishedTime;
    }

    @Basic
    @Column(name = "goods_amount", nullable = false, precision = 2)
    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    @Basic
    @Column(name = "discount", nullable = false, precision = 2)
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "order_amount", nullable = false, precision = 2)
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Basic
    @Column(name = "evaluation_status", nullable = false)
    public byte getEvaluationStatus() {
        return evaluationStatus;
    }

    public void setEvaluationStatus(byte evaluationStatus) {
        this.evaluationStatus = evaluationStatus;
    }

    @Basic
    @Column(name = "evaluation_time", nullable = false)
    public int getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(int evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    @Basic
    @Column(name = "anonymous", nullable = false)
    public byte getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(byte anonymous) {
        this.anonymous = anonymous;
    }

    @Basic
    @Column(name = "postscript", nullable = false, length = 255)
    public String getPostscript() {
        return postscript;
    }

    public void setPostscript(String postscript) {
        this.postscript = postscript;
    }

    @Basic
    @Column(name = "pay_alter", nullable = false)
    public byte getPayAlter() {
        return payAlter;
    }

    public void setPayAlter(byte payAlter) {
        this.payAlter = payAlter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmOrderEntity that = (EcmOrderEntity) o;

        if (orderId != that.orderId) return false;
        if (sellerId != that.sellerId) return false;
        if (buyerId != that.buyerId) return false;
        if (status != that.status) return false;
        if (addTime != that.addTime) return false;
        if (finishedTime != that.finishedTime) return false;
        if (evaluationStatus != that.evaluationStatus) return false;
        if (evaluationTime != that.evaluationTime) return false;
        if (anonymous != that.anonymous) return false;
        if (payAlter != that.payAlter) return false;
        if (orderSn != null ? !orderSn.equals(that.orderSn) : that.orderSn != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (extension != null ? !extension.equals(that.extension) : that.extension != null) return false;
        if (sellerName != null ? !sellerName.equals(that.sellerName) : that.sellerName != null) return false;
        if (buyerName != null ? !buyerName.equals(that.buyerName) : that.buyerName != null) return false;
        if (buyerEmail != null ? !buyerEmail.equals(that.buyerEmail) : that.buyerEmail != null) return false;
        if (paymentId != null ? !paymentId.equals(that.paymentId) : that.paymentId != null) return false;
        if (paymentName != null ? !paymentName.equals(that.paymentName) : that.paymentName != null) return false;
        if (paymentCode != null ? !paymentCode.equals(that.paymentCode) : that.paymentCode != null) return false;
        if (outTradeSn != null ? !outTradeSn.equals(that.outTradeSn) : that.outTradeSn != null) return false;
        if (payTime != null ? !payTime.equals(that.payTime) : that.payTime != null) return false;
        if (payMessage != null ? !payMessage.equals(that.payMessage) : that.payMessage != null) return false;
        if (shipTime != null ? !shipTime.equals(that.shipTime) : that.shipTime != null) return false;
        if (invoiceNo != null ? !invoiceNo.equals(that.invoiceNo) : that.invoiceNo != null) return false;
        if (goodsAmount != null ? !goodsAmount.equals(that.goodsAmount) : that.goodsAmount != null) return false;
        if (discount != null ? !discount.equals(that.discount) : that.discount != null) return false;
        if (orderAmount != null ? !orderAmount.equals(that.orderAmount) : that.orderAmount != null) return false;
        if (postscript != null ? !postscript.equals(that.postscript) : that.postscript != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (orderSn != null ? orderSn.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        result = 31 * result + sellerId;
        result = 31 * result + (sellerName != null ? sellerName.hashCode() : 0);
        result = 31 * result + buyerId;
        result = 31 * result + (buyerName != null ? buyerName.hashCode() : 0);
        result = 31 * result + (buyerEmail != null ? buyerEmail.hashCode() : 0);
        result = 31 * result + (int) status;
        result = 31 * result + addTime;
        result = 31 * result + (paymentId != null ? paymentId.hashCode() : 0);
        result = 31 * result + (paymentName != null ? paymentName.hashCode() : 0);
        result = 31 * result + (paymentCode != null ? paymentCode.hashCode() : 0);
        result = 31 * result + (outTradeSn != null ? outTradeSn.hashCode() : 0);
        result = 31 * result + (payTime != null ? payTime.hashCode() : 0);
        result = 31 * result + (payMessage != null ? payMessage.hashCode() : 0);
        result = 31 * result + (shipTime != null ? shipTime.hashCode() : 0);
        result = 31 * result + (invoiceNo != null ? invoiceNo.hashCode() : 0);
        result = 31 * result + finishedTime;
        result = 31 * result + (goodsAmount != null ? goodsAmount.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (orderAmount != null ? orderAmount.hashCode() : 0);
        result = 31 * result + (int) evaluationStatus;
        result = 31 * result + evaluationTime;
        result = 31 * result + (int) anonymous;
        result = 31 * result + (postscript != null ? postscript.hashCode() : 0);
        result = 31 * result + (int) payAlter;
        return result;
    }
}
