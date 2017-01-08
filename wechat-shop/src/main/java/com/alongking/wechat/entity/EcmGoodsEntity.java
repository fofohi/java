package com.alongking.wechat.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_goods", schema = "fenshang", catalog = "")
public class EcmGoodsEntity {
    private int goodsId;
    private int storeId;
    private String type;
    private String goodsName;
    private String description;
    private int cateId;
    private String cateName;
    private String brand;
    private byte specQty;
    private String specName1;
    private String specName2;
    private byte ifShow;
    private byte closed;
    private String closeReason;
    private int addTime;
    private int lastUpdate;
    private int defaultSpec;
    private String defaultImage;
    private byte recommended;
    private int cateId1;
    private int cateId2;
    private int cateId3;
    private int cateId4;
    private BigDecimal price;
    private String tags;

    @Id
    @Column(name = "goods_id", nullable = false)
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
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
    @Column(name = "type", nullable = false, length = 10)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "goods_name", nullable = false, length = 255)
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "cate_id", nullable = false)
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    @Basic
    @Column(name = "cate_name", nullable = false, length = 255)
    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Basic
    @Column(name = "brand", nullable = false, length = 100)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "spec_qty", nullable = false)
    public byte getSpecQty() {
        return specQty;
    }

    public void setSpecQty(byte specQty) {
        this.specQty = specQty;
    }

    @Basic
    @Column(name = "spec_name_1", nullable = false, length = 60)
    public String getSpecName1() {
        return specName1;
    }

    public void setSpecName1(String specName1) {
        this.specName1 = specName1;
    }

    @Basic
    @Column(name = "spec_name_2", nullable = false, length = 60)
    public String getSpecName2() {
        return specName2;
    }

    public void setSpecName2(String specName2) {
        this.specName2 = specName2;
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
    @Column(name = "closed", nullable = false)
    public byte getClosed() {
        return closed;
    }

    public void setClosed(byte closed) {
        this.closed = closed;
    }

    @Basic
    @Column(name = "close_reason", nullable = true, length = 255)
    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    @Basic
    @Column(name = "add_time", nullable = false)
    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "last_update", nullable = false)
    public int getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(int lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Basic
    @Column(name = "default_spec", nullable = false)
    public int getDefaultSpec() {
        return defaultSpec;
    }

    public void setDefaultSpec(int defaultSpec) {
        this.defaultSpec = defaultSpec;
    }

    @Basic
    @Column(name = "default_image", nullable = false, length = 255)
    public String getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(String defaultImage) {
        this.defaultImage = defaultImage;
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
    @Column(name = "cate_id_1", nullable = false)
    public int getCateId1() {
        return cateId1;
    }

    public void setCateId1(int cateId1) {
        this.cateId1 = cateId1;
    }

    @Basic
    @Column(name = "cate_id_2", nullable = false)
    public int getCateId2() {
        return cateId2;
    }

    public void setCateId2(int cateId2) {
        this.cateId2 = cateId2;
    }

    @Basic
    @Column(name = "cate_id_3", nullable = false)
    public int getCateId3() {
        return cateId3;
    }

    public void setCateId3(int cateId3) {
        this.cateId3 = cateId3;
    }

    @Basic
    @Column(name = "cate_id_4", nullable = false)
    public int getCateId4() {
        return cateId4;
    }

    public void setCateId4(int cateId4) {
        this.cateId4 = cateId4;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "tags", nullable = false, length = 102)
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmGoodsEntity that = (EcmGoodsEntity) o;

        if (goodsId != that.goodsId) return false;
        if (storeId != that.storeId) return false;
        if (cateId != that.cateId) return false;
        if (specQty != that.specQty) return false;
        if (ifShow != that.ifShow) return false;
        if (closed != that.closed) return false;
        if (addTime != that.addTime) return false;
        if (lastUpdate != that.lastUpdate) return false;
        if (defaultSpec != that.defaultSpec) return false;
        if (recommended != that.recommended) return false;
        if (cateId1 != that.cateId1) return false;
        if (cateId2 != that.cateId2) return false;
        if (cateId3 != that.cateId3) return false;
        if (cateId4 != that.cateId4) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (goodsName != null ? !goodsName.equals(that.goodsName) : that.goodsName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (cateName != null ? !cateName.equals(that.cateName) : that.cateName != null) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (specName1 != null ? !specName1.equals(that.specName1) : that.specName1 != null) return false;
        if (specName2 != null ? !specName2.equals(that.specName2) : that.specName2 != null) return false;
        if (closeReason != null ? !closeReason.equals(that.closeReason) : that.closeReason != null) return false;
        if (defaultImage != null ? !defaultImage.equals(that.defaultImage) : that.defaultImage != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (tags != null ? !tags.equals(that.tags) : that.tags != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = goodsId;
        result = 31 * result + storeId;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + cateId;
        result = 31 * result + (cateName != null ? cateName.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (int) specQty;
        result = 31 * result + (specName1 != null ? specName1.hashCode() : 0);
        result = 31 * result + (specName2 != null ? specName2.hashCode() : 0);
        result = 31 * result + (int) ifShow;
        result = 31 * result + (int) closed;
        result = 31 * result + (closeReason != null ? closeReason.hashCode() : 0);
        result = 31 * result + addTime;
        result = 31 * result + lastUpdate;
        result = 31 * result + defaultSpec;
        result = 31 * result + (defaultImage != null ? defaultImage.hashCode() : 0);
        result = 31 * result + (int) recommended;
        result = 31 * result + cateId1;
        result = 31 * result + cateId2;
        result = 31 * result + cateId3;
        result = 31 * result + cateId4;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        return result;
    }
}
