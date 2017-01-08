package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_recommend", schema = "fenshang", catalog = "")
public class EcmRecommendEntity {
    private int recomId;
    private String recomName;
    private int storeId;

    @Id
    @Column(name = "recom_id", nullable = false)
    public int getRecomId() {
        return recomId;
    }

    public void setRecomId(int recomId) {
        this.recomId = recomId;
    }

    @Basic
    @Column(name = "recom_name", nullable = false, length = 100)
    public String getRecomName() {
        return recomName;
    }

    public void setRecomName(String recomName) {
        this.recomName = recomName;
    }

    @Basic
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

        EcmRecommendEntity that = (EcmRecommendEntity) o;

        if (recomId != that.recomId) return false;
        if (storeId != that.storeId) return false;
        if (recomName != null ? !recomName.equals(that.recomName) : that.recomName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recomId;
        result = 31 * result + (recomName != null ? recomName.hashCode() : 0);
        result = 31 * result + storeId;
        return result;
    }
}
