package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_coupon_sn", schema = "fenshang", catalog = "")
public class EcmCouponSnEntity {
    private String couponSn;
    private int couponId;
    private int remainTimes;

    @Id
    @Column(name = "coupon_sn", nullable = false, length = 20)
    public String getCouponSn() {
        return couponSn;
    }

    public void setCouponSn(String couponSn) {
        this.couponSn = couponSn;
    }

    @Basic
    @Column(name = "coupon_id", nullable = false)
    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    @Basic
    @Column(name = "remain_times", nullable = false)
    public int getRemainTimes() {
        return remainTimes;
    }

    public void setRemainTimes(int remainTimes) {
        this.remainTimes = remainTimes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmCouponSnEntity that = (EcmCouponSnEntity) o;

        if (couponId != that.couponId) return false;
        if (remainTimes != that.remainTimes) return false;
        if (couponSn != null ? !couponSn.equals(that.couponSn) : that.couponSn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = couponSn != null ? couponSn.hashCode() : 0;
        result = 31 * result + couponId;
        result = 31 * result + remainTimes;
        return result;
    }
}
