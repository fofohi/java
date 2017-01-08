package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_groupbuy", schema = "fenshang", catalog = "")
public class EcmGroupbuyEntity {
    private int groupId;
    private String groupName;
    private String groupDesc;
    private int startTime;
    private int endTime;
    private int goodsId;
    private int storeId;
    private String specPrice;
    private short minQuantity;
    private short maxPerUser;
    private byte state;
    private byte recommended;
    private int views;

    @Id
    @Column(name = "group_id", nullable = false)
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "group_name", nullable = false, length = 255)
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "group_desc", nullable = false, length = 255)
    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    @Basic
    @Column(name = "start_time", nullable = false)
    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time", nullable = false)
    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Basic
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
    @Column(name = "spec_price", nullable = false, length = -1)
    public String getSpecPrice() {
        return specPrice;
    }

    public void setSpecPrice(String specPrice) {
        this.specPrice = specPrice;
    }

    @Basic
    @Column(name = "min_quantity", nullable = false)
    public short getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(short minQuantity) {
        this.minQuantity = minQuantity;
    }

    @Basic
    @Column(name = "max_per_user", nullable = false)
    public short getMaxPerUser() {
        return maxPerUser;
    }

    public void setMaxPerUser(short maxPerUser) {
        this.maxPerUser = maxPerUser;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
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
    @Column(name = "views", nullable = false)
    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmGroupbuyEntity that = (EcmGroupbuyEntity) o;

        if (groupId != that.groupId) return false;
        if (startTime != that.startTime) return false;
        if (endTime != that.endTime) return false;
        if (goodsId != that.goodsId) return false;
        if (storeId != that.storeId) return false;
        if (minQuantity != that.minQuantity) return false;
        if (maxPerUser != that.maxPerUser) return false;
        if (state != that.state) return false;
        if (recommended != that.recommended) return false;
        if (views != that.views) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (groupDesc != null ? !groupDesc.equals(that.groupDesc) : that.groupDesc != null) return false;
        if (specPrice != null ? !specPrice.equals(that.specPrice) : that.specPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (groupDesc != null ? groupDesc.hashCode() : 0);
        result = 31 * result + startTime;
        result = 31 * result + endTime;
        result = 31 * result + goodsId;
        result = 31 * result + storeId;
        result = 31 * result + (specPrice != null ? specPrice.hashCode() : 0);
        result = 31 * result + (int) minQuantity;
        result = 31 * result + (int) maxPerUser;
        result = 31 * result + (int) state;
        result = 31 * result + (int) recommended;
        result = 31 * result + views;
        return result;
    }
}
