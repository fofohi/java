package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_sessions", schema = "fenshang", catalog = "")
public class EcmSessionsEntity {
    private String sesskey;
    private int expiry;
    private int userid;
    private int adminid;
    private String ip;
    private String data;
    private byte isOverflow;

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
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "adminid", nullable = false)
    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    @Basic
    @Column(name = "ip", nullable = false, length = 15)
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "data", nullable = false, length = 255)
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Basic
    @Column(name = "is_overflow", nullable = false)
    public byte getIsOverflow() {
        return isOverflow;
    }

    public void setIsOverflow(byte isOverflow) {
        this.isOverflow = isOverflow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmSessionsEntity that = (EcmSessionsEntity) o;

        if (expiry != that.expiry) return false;
        if (userid != that.userid) return false;
        if (adminid != that.adminid) return false;
        if (isOverflow != that.isOverflow) return false;
        if (sesskey != null ? !sesskey.equals(that.sesskey) : that.sesskey != null) return false;
        if (ip != null ? !ip.equals(that.ip) : that.ip != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sesskey != null ? sesskey.hashCode() : 0;
        result = 31 * result + expiry;
        result = 31 * result + userid;
        result = 31 * result + adminid;
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (int) isOverflow;
        return result;
    }
}
