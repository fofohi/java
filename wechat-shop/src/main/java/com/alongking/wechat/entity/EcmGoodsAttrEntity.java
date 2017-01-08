package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_goods_attr", schema = "fenshang", catalog = "")
public class EcmGoodsAttrEntity {
    private int gattrId;
    private int goodsId;
    private String attrName;
    private String attrValue;
    private Integer attrId;
    private Byte sortOrder;

    @Id
    @Column(name = "gattr_id", nullable = false)
    public int getGattrId() {
        return gattrId;
    }

    public void setGattrId(int gattrId) {
        this.gattrId = gattrId;
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
    @Column(name = "attr_name", nullable = false, length = 60)
    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    @Basic
    @Column(name = "attr_value", nullable = false, length = 255)
    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    @Basic
    @Column(name = "attr_id", nullable = true)
    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    @Basic
    @Column(name = "sort_order", nullable = true)
    public Byte getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmGoodsAttrEntity that = (EcmGoodsAttrEntity) o;

        if (gattrId != that.gattrId) return false;
        if (goodsId != that.goodsId) return false;
        if (attrName != null ? !attrName.equals(that.attrName) : that.attrName != null) return false;
        if (attrValue != null ? !attrValue.equals(that.attrValue) : that.attrValue != null) return false;
        if (attrId != null ? !attrId.equals(that.attrId) : that.attrId != null) return false;
        if (sortOrder != null ? !sortOrder.equals(that.sortOrder) : that.sortOrder != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gattrId;
        result = 31 * result + goodsId;
        result = 31 * result + (attrName != null ? attrName.hashCode() : 0);
        result = 31 * result + (attrValue != null ? attrValue.hashCode() : 0);
        result = 31 * result + (attrId != null ? attrId.hashCode() : 0);
        result = 31 * result + (sortOrder != null ? sortOrder.hashCode() : 0);
        return result;
    }
}
