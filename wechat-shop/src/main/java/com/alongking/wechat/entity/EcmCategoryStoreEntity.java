package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_category_store", schema = "fenshang", catalog = "")
@IdClass(EcmCategoryStoreEntityPK.class)
public class EcmCategoryStoreEntity {
    private int cateId;
    private int storeId;

    @Id
    @Column(name = "cate_id", nullable = false)
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    @Id
    @Column(name = "store_id", nullable = false)
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

        EcmCategoryStoreEntity that = (EcmCategoryStoreEntity) o;

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
