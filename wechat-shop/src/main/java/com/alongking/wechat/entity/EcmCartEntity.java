package com.alongking.wechat.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_cart", schema = "fenshang", catalog = "")
public class EcmCartEntity {
    private int recId;
    private int userId;
    private String sessionId;
    private int storeId;
    private int goodsId;
    private String goodsName;
    private int specId;
    private String specification;
    private BigDecimal price;
    private int quantity;
    private String goodsImage;

    @Id
    @Column(name = "rec_id", nullable = false)
    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "session_id", nullable = false, length = 32)
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Basic
    @Column(name = "store_id", nullable = false)
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmCartEntity that = (EcmCartEntity) o;

        if (recId != that.recId) return false;
        if (userId != that.userId) return false;
        if (storeId != that.storeId) return false;
        if (goodsId != that.goodsId) return false;
        if (specId != that.specId) return false;
        if (quantity != that.quantity) return false;
        if (sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null) return false;
        if (goodsName != null ? !goodsName.equals(that.goodsName) : that.goodsName != null) return false;
        if (specification != null ? !specification.equals(that.specification) : that.specification != null)
            return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (goodsImage != null ? !goodsImage.equals(that.goodsImage) : that.goodsImage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recId;
        result = 31 * result + userId;
        result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
        result = 31 * result + storeId;
        result = 31 * result + goodsId;
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + specId;
        result = 31 * result + (specification != null ? specification.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (goodsImage != null ? goodsImage.hashCode() : 0);
        return result;
    }
}
