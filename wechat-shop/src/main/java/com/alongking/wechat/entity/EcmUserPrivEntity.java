package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_user_priv", schema = "fenshang", catalog = "")
@IdClass(EcmUserPrivEntityPK.class)
public class EcmUserPrivEntity {
    private int userId;
    private int storeId;
    private String privs;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "store_id", nullable = false)
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "privs", nullable = false, length = -1)
    public String getPrivs() {
        return privs;
    }

    public void setPrivs(String privs) {
        this.privs = privs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmUserPrivEntity that = (EcmUserPrivEntity) o;

        if (userId != that.userId) return false;
        if (storeId != that.storeId) return false;
        if (privs != null ? !privs.equals(that.privs) : that.privs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + storeId;
        result = 31 * result + (privs != null ? privs.hashCode() : 0);
        return result;
    }
}
