package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_brand", schema = "fenshang", catalog = "")
public class EcmBrandEntity {
    private int brandId;
    private String brandName;
    private String brandLogo;
    private byte sortOrder;
    private byte recommended;
    private int storeId;
    private byte ifShow;
    private String tag;

    @Id
    @Column(name = "brand_id", nullable = false)
    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    @Basic
    @Column(name = "brand_name", nullable = false, length = 100)
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Basic
    @Column(name = "brand_logo", nullable = true, length = 255)
    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
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
    @Column(name = "recommended", nullable = false)
    public byte getRecommended() {
        return recommended;
    }

    public void setRecommended(byte recommended) {
        this.recommended = recommended;
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
    @Column(name = "if_show", nullable = false)
    public byte getIfShow() {
        return ifShow;
    }

    public void setIfShow(byte ifShow) {
        this.ifShow = ifShow;
    }

    @Basic
    @Column(name = "tag", nullable = false, length = 100)
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmBrandEntity that = (EcmBrandEntity) o;

        if (brandId != that.brandId) return false;
        if (sortOrder != that.sortOrder) return false;
        if (recommended != that.recommended) return false;
        if (storeId != that.storeId) return false;
        if (ifShow != that.ifShow) return false;
        if (brandName != null ? !brandName.equals(that.brandName) : that.brandName != null) return false;
        if (brandLogo != null ? !brandLogo.equals(that.brandLogo) : that.brandLogo != null) return false;
        if (tag != null ? !tag.equals(that.tag) : that.tag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = brandId;
        result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
        result = 31 * result + (brandLogo != null ? brandLogo.hashCode() : 0);
        result = 31 * result + (int) sortOrder;
        result = 31 * result + (int) recommended;
        result = 31 * result + storeId;
        result = 31 * result + (int) ifShow;
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        return result;
    }
}
