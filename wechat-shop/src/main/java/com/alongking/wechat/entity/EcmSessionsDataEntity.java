package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_sessions_data", schema = "fenshang", catalog = "")
public class EcmSessionsDataEntity {
    private String sesskey;
    private int expiry;
    private String data;

    @Id
    @Column(name = "sesskey", nullable = false, length = 32)
    public String getSesskey() {
        return sesskey;
    }

    public void setSesskey(String sesskey) {
        this.sesskey = sesskey;
    }

    @Basic
    @Column(name = "expiry", nullable = false)
    public int getExpiry() {
        return expiry;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    @Basic
    @Column(name = "data", nullable = false, length = -1)
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmSessionsDataEntity that = (EcmSessionsDataEntity) o;

        if (expiry != that.expiry) return false;
        if (sesskey != null ? !sesskey.equals(that.sesskey) : that.sesskey != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sesskey != null ? sesskey.hashCode() : 0;
        result = 31 * result + expiry;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
