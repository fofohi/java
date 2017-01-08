package com.alongking.wechat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by alongsea2 on 2017/1/8.
 */
public class EcmUserPrivEntityPK implements Serializable {
    private int userId;
    private int storeId;

    @Column(name = "user_id", nullable = false)
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

        EcmUserPrivEntityPK that = (EcmUserPrivEntityPK) o;

        if (userId != that.userId) return false;
        if (storeId != that.storeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + storeId;
        return result;
    }
}
