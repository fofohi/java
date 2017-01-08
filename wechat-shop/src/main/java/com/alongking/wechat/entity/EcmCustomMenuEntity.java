package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_custom_menu", schema = "fenshang", catalog = "")
public class EcmCustomMenuEntity {
    private int cateId;
    private int storeId;
    private String cateName;
    private int parentId;
    private byte sortOrder;
    private byte ifShow;
    private String token;
    private String keyvalue;
    private String keyword;
    private byte type;

    @Id
    @Column(name = "cate_id", nullable = false)
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    @Basic
    @Column(name = "store_id", nullable = false)
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "cate_name", nullable = false, length = 100)
    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Basic
    @Column(name = "parent_id", nullable = false)
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "sort_order", nullable = false)
    public byte getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Basic
    @Column(name = "if_show", nullable = false)
    public byte getIfShow() {
        return ifShow;
    }

    public void setIfShow(byte ifShow) {
        this.ifShow = ifShow;
    }

    @Basic
    @Column(name = "token", nullable = false, length = 255)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "keyvalue", nullable = true, length = 255)
    public String getKeyvalue() {
        return keyvalue;
    }

    public void setKeyvalue(String keyvalue) {
        this.keyvalue = keyvalue;
    }

    @Basic
    @Column(name = "keyword", nullable = true, length = 255)
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmCustomMenuEntity that = (EcmCustomMenuEntity) o;

        if (cateId != that.cateId) return false;
        if (storeId != that.storeId) return false;
        if (parentId != that.parentId) return false;
        if (sortOrder != that.sortOrder) return false;
        if (ifShow != that.ifShow) return false;
        if (type != that.type) return false;
        if (cateName != null ? !cateName.equals(that.cateName) : that.cateName != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        if (keyvalue != null ? !keyvalue.equals(that.keyvalue) : that.keyvalue != null) return false;
        if (keyword != null ? !keyword.equals(that.keyword) : that.keyword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cateId;
        result = 31 * result + storeId;
        result = 31 * result + (cateName != null ? cateName.hashCode() : 0);
        result = 31 * result + parentId;
        result = 31 * result + (int) sortOrder;
        result = 31 * result + (int) ifShow;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (keyvalue != null ? keyvalue.hashCode() : 0);
        result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
        result = 31 * result + (int) type;
        return result;
    }
}
