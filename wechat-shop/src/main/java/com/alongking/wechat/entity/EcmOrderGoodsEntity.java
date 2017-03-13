package com.alongking.wechat.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_order_goods", schema = "fenshang", catalog = "")
public class EcmOrderGoodsEntity {
    private int recId;
    private int orderId;
    private int goodsId;
    private String goodsName;
    private int specId;
    private String specification;
    private BigDecimal price;
    private int quantity;
    private String goodsImage;
    private int evaluation = 0;
    private String comment;
    private int creditValue = 0;
    private int isValid = 1;

    @Id
    @Column(name = "rec_id", nullable = false)
    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
    }

    @Basic
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "goods_id", nullable = false)
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "goods_name", nullable = false, length = 255)
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Basic
    @Column(name = "spec_id", nullable = false)
    public int getSpecId() {
        return specId;
    }

    public void setSpecId(int specId) {
        this.specId = specId;
    }

    @Basic
    @Column(name = "specification", nullable = true, length = 255)
    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "goods_image", nullable = true, length = 255)
    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    @Basic
    @Column(name = "evaluation", nullable = false)
    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    @Basic
    @Column(name = "comment", nullable = false, length = 255)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "credit_value", nullable = false)
    public int getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(int creditValue) {
        this.creditValue = creditValue;
    }

    @Basic
    @Column(name = "is_valid", nullable = false)
    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmOrderGoodsEntity that = (EcmOrderGoodsEntity) o;

        if (recId != that.recId) return false;
        if (orderId != that.orderId) return false;
        if (goodsId != that.goodsId) return false;
        if (specId != that.specId) return false;
        if (quantity != that.quantity) return false;
        if (evaluation != that.evaluation) return false;
        if (creditValue != that.creditValue) return false;
        if (isValid != that.isValid) return false;
        if (goodsName != null ? !goodsName.equals(that.goodsName) : that.goodsName != null) return false;
        if (specification != null ? !specification.equals(that.specification) : that.specification != null)
            return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (goodsImage != null ? !goodsImage.equals(that.goodsImage) : that.goodsImage != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recId;
        result = 31 * result + orderId;
        result = 31 * result + goodsId;
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + specId;
        result = 31 * result + (specification != null ? specification.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (goodsImage != null ? goodsImage.hashCode() : 0);
        result = 31 * result + (int) evaluation;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (int) creditValue;
        result = 31 * result + (int) isValid;
        return result;
    }
}
