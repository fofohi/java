package com.alongking.wechat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by alongsea2 on 2017/1/8.
 */
public class EcmUserCouponEntityPK implements Serializable {
    private int userId;
    private String couponSn;

    @Column(name = "user_id", nullable = false)
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "coupon_sn", nullable = false, length = 20)
    @Id
    public String getCouponSn() {
        return couponSn;
    }

    public void setCouponSn(String couponSn) {
        this.couponSn = couponSn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmUserCouponEntityPK that = (EcmUserCouponEntityPK) o;

        if (userId != that.userId) return false;
        if (couponSn != null ? !couponSn.equals(that.couponSn) : that.couponSn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (couponSn != null ? couponSn.hashCode() : 0);
        return result;
    }
}
