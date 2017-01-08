package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_wechat", schema = "fenshang", catalog = "")
public class EcmWechatEntity {
    private int id;
    private String wxname;
    private String weixin;
    private String token;
    private int userId;
    private byte wxType;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "wxname", nullable = false, length = 255)
    public String getWxname() {
        return wxname;
    }

    public void setWxname(String wxname) {
        this.wxname = wxname;
    }

    @Basic
    @Column(name = "weixin", nullable = false, length = 255)
    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    @Basic
    @Column(name = "token", nullable = false, length = 32)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "wx_type", nullable = false)
    public byte getWxType() {
        return wxType;
    }

    public void setWxType(byte wxType) {
        this.wxType = wxType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmWechatEntity that = (EcmWechatEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (wxType != that.wxType) return false;
        if (wxname != null ? !wxname.equals(that.wxname) : that.wxname != null) return false;
        if (weixin != null ? !weixin.equals(that.weixin) : that.weixin != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (wxname != null ? wxname.hashCode() : 0);
        result = 31 * result + (weixin != null ? weixin.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (int) wxType;
        return result;
    }
}
