package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_scategory", schema = "fenshang", catalog = "")
public class EcmScategoryEntity {
    private int cateId;
    private String cateName;
    private int parentId;
    private byte sortOrder;

    @Id
    @Column(name = "cate_id", nullable = false)
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmScategoryEntity that = (EcmScategoryEntity) o;

        if (cateId != that.cateId) return false;
        if (parentId != that.parentId) return false;
        if (sortOrder != that.sortOrder) return false;
        if (cateName != null ? !cateName.equals(that.cateName) : that.cateName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cateId;
        result = 31 * result + (cateName != null ? cateName.hashCode() : 0);
        result = 31 * result + parentId;
        result = 31 * result + (int) sortOrder;
        return result;
    }
}
