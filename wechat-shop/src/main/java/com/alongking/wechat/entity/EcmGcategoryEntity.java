package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_gcategory", schema = "fenshang", catalog = "")
public class EcmGcategoryEntity {
    private int cateId;
    private int storeId;
    private String cateName;
    private int parentId;
    private byte sortOrder;
    private byte ifShow;
    private String cateImages;

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
    @Column(name = "cate_images", nullable = true, length = 255)
    public String getCateImages() {
        return cateImages;
    }

    public void setCateImages(String cateImages) {
        this.cateImages = cateImages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmGcategoryEntity that = (EcmGcategoryEntity) o;

        if (cateId != that.cateId) return false;
        if (storeId != that.storeId) return false;
        if (parentId != that.parentId) return false;
        if (sortOrder != that.sortOrder) return false;
        if (ifShow != that.ifShow) return false;
        if (cateName != null ? !cateName.equals(that.cateName) : that.cateName != null) return false;
        if (cateImages != null ? !cateImages.equals(that.cateImages) : that.cateImages != null) return false;

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
        result = 31 * result + (cateImages != null ? cateImages.hashCode() : 0);
        return result;
    }
}
