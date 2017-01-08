package com.alongking.wechat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by alongsea2 on 2017/1/8.
 */
public class EcmCategoryStoreEntityPK implements Serializable {
    private int cateId;
    private int storeId;

    @Column(name = "cate_id", nullable = false)
    @Id
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    @Column(name = "store_id", nullable = false)
    @Id
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmCategoryStoreEntityPK that = (EcmCategoryStoreEntityPK) o;

        if (cateId != that.cateId) return false;
        if (storeId != that.storeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cateId;
        result = 31 * result + storeId;
        return result;
    }
}
