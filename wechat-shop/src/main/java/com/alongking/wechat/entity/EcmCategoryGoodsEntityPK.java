package com.alongking.wechat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by alongsea2 on 2017/1/8.
 */
public class EcmCategoryGoodsEntityPK implements Serializable {
    private int cateId;
    private int goodsId;

    @Column(name = "cate_id", nullable = false)
    @Id
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
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

        EcmCategoryGoodsEntityPK that = (EcmCategoryGoodsEntityPK) o;

        if (cateId != that.cateId) return false;
        if (goodsId != that.goodsId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cateId;
        result = 31 * result + goodsId;
        return result;
    }
}
