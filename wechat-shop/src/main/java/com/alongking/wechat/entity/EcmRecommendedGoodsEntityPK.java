package com.alongking.wechat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by alongsea2 on 2017/1/8.
 */
public class EcmRecommendedGoodsEntityPK implements Serializable {
    private int recomId;
    private int goodsId;

    @Column(name = "recom_id", nullable = false)
    @Id
    public int getRecomId() {
        return recomId;
    }

    public void setRecomId(int recomId) {
        this.recomId = recomId;
    }

    @Column(name = "goods_id", nullable = false)
    @Id
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmRecommendedGoodsEntityPK that = (EcmRecommendedGoodsEntityPK) o;

        if (recomId != that.recomId) return false;
        if (goodsId != that.goodsId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recomId;
        result = 31 * result + goodsId;
        return result;
    }
}
