package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_recommended_goods", schema = "fenshang", catalog = "")
@IdClass(EcmRecommendedGoodsEntityPK.class)
public class EcmRecommendedGoodsEntity {
    private int recomId;
    private int goodsId;
    private byte sortOrder;

    @Id
    @Column(name = "recom_id", nullable = false)
    public int getRecomId() {
        return recomId;
    }

    public void setRecomId(int recomId) {
        this.recomId = recomId;
    }

    @Id
    @Column(name = "goods_id", nullable = false)
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "sort_order", nullable = false)
    public byte getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmRecommendedGoodsEntity that = (EcmRecommendedGoodsEntity) o;

        if (recomId != that.recomId) return false;
        if (goodsId != that.goodsId) return false;
        if (sortOrder != that.sortOrder) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recomId;
        result = 31 * result + goodsId;
        result = 31 * result + (int) sortOrder;
        return result;
    }
}
