package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_category_goods", schema = "fenshang", catalog = "")
@IdClass(EcmCategoryGoodsEntityPK.class)
public class EcmCategoryGoodsEntity {
    private int cateId;
    private int goodsId;

    @Id
    @Column(name = "cate_id", nullable = false)
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    @Id
    @Column(name = "goods_id", nullable = false)
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

        EcmCategoryGoodsEntity that = (EcmCategoryGoodsEntity) o;

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
