package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_wxconfig", schema = "fenshang", catalog = "")
public class EcmWxconfigEntity {
    private int id;
    private String appid;
    private String appsecret;
    private int userId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "appid", nullable = false, length = 255)
    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    @Basic
    @Column(name = "appsecret", nullable = false, length = 255)
    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmWxconfigEntity that = (EcmWxconfigEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (appid != null ? !appid.equals(that.appid) : that.appid != null) return false;
        if (appsecret != null ? !appsecret.equals(that.appsecret) : that.appsecret != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (appid != null ? appid.hashCode() : 0);
        result = 31 * result + (appsecret != null ? appsecret.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }
}
