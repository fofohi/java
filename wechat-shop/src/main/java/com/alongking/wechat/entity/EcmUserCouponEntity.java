package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_user_coupon", schema = "fenshang", catalog = "")
@IdClass(EcmUserCouponEntityPK.class)
public class EcmUserCouponEntity {
    private int userId;
    private String couponSn;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "coupon_sn", nullable = false, length = 20)
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

        EcmUserCouponEntity that = (EcmUserCouponEntity) o;

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
