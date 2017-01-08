package com.alongking.wechat.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_coupon", schema = "fenshang", catalog = "")
public class EcmCouponEntity {
    private int couponId;
    private int storeId;
    private String couponName;
    private BigDecimal couponValue;
    private int useTimes;
    private int startTime;
    private int endTime;
    private BigDecimal minAmount;
    private byte ifIssue;

    @Id
    @Column(name = "coupon_id", nullable = false)
    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
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
    @Column(name = "coupon_name", nullable = false, length = 100)
    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    @Basic
    @Column(name = "coupon_value", nullable = false, precision = 2)
    public BigDecimal getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(BigDecimal couponValue) {
        this.couponValue = couponValue;
    }

    @Basic
    @Column(name = "use_times", nullable = false)
    public int getUseTimes() {
        return useTimes;
    }

    public void setUseTimes(int useTimes) {
        this.useTimes = useTimes;
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
    @Column(name = "min_amount", nullable = false, precision = 2)
    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    @Basic
    @Column(name = "if_issue", nullable = false)
    public byte getIfIssue() {
        return ifIssue;
    }

    public void setIfIssue(byte ifIssue) {
        this.ifIssue = ifIssue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmCouponEntity that = (EcmCouponEntity) o;

        if (couponId != that.couponId) return false;
        if (storeId != that.storeId) return false;
        if (useTimes != that.useTimes) return false;
        if (startTime != that.startTime) return false;
        if (endTime != that.endTime) return false;
        if (ifIssue != that.ifIssue) return false;
        if (couponName != null ? !couponName.equals(that.couponName) : that.couponName != null) return false;
        if (couponValue != null ? !couponValue.equals(that.couponValue) : that.couponValue != null) return false;
        if (minAmount != null ? !minAmount.equals(that.minAmount) : that.minAmount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = couponId;
        result = 31 * result + storeId;
        result = 31 * result + (couponName != null ? couponName.hashCode() : 0);
        result = 31 * result + (couponValue != null ? couponValue.hashCode() : 0);
        result = 31 * result + useTimes;
        result = 31 * result + startTime;
        result = 31 * result + endTime;
        result = 31 * result + (minAmount != null ? minAmount.hashCode() : 0);
        result = 31 * result + (int) ifIssue;
        return result;
    }
}
