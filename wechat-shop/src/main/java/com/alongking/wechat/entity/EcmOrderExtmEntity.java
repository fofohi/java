package com.alongking.wechat.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_order_extm", schema = "fenshang", catalog = "")
public class EcmOrderExtmEntity {
    private int orderId;
    private String consignee;
    private Integer regionId;
    private String regionName;
    private String address;
    private String zipcode = "";
    private String phoneTel;
    private String phoneMob;
    private Integer shippingId = 0;
    private String shippingName = "";
    private BigDecimal shippingFee = new BigDecimal(0);

    @Id
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "consignee", nullable = false, length = 60)
    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    @Basic
    @Column(name = "region_id", nullable = true)
    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    @Basic
    @Column(name = "region_name", nullable = true, length = 255)
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "zipcode", nullable = true, length = 20)
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "phone_tel", nullable = true, length = 60)
    public String getPhoneTel() {
        return phoneTel;
    }

    public void setPhoneTel(String phoneTel) {
        this.phoneTel = phoneTel;
    }

    @Basic
    @Column(name = "phone_mob", nullable = true, length = 60)
    public String getPhoneMob() {
        return phoneMob;
    }

    public void setPhoneMob(String phoneMob) {
        this.phoneMob = phoneMob;
    }

    @Basic
    @Column(name = "shipping_id", nullable = true)
    public Integer getShippingId() {
        return shippingId;
    }

    public void setShippingId(Integer shippingId) {
        this.shippingId = shippingId;
    }

    @Basic
    @Column(name = "shipping_name", nullable = true, length = 100)
    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    @Basic
    @Column(name = "shipping_fee", nullable = false, precision = 2)
    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmOrderExtmEntity that = (EcmOrderExtmEntity) o;

        if (orderId != that.orderId) return false;
        if (consignee != null ? !consignee.equals(that.consignee) : that.consignee != null) return false;
        if (regionId != null ? !regionId.equals(that.regionId) : that.regionId != null) return false;
        if (regionName != null ? !regionName.equals(that.regionName) : that.regionName != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (zipcode != null ? !zipcode.equals(that.zipcode) : that.zipcode != null) return false;
        if (phoneTel != null ? !phoneTel.equals(that.phoneTel) : that.phoneTel != null) return false;
        if (phoneMob != null ? !phoneMob.equals(that.phoneMob) : that.phoneMob != null) return false;
        if (shippingId != null ? !shippingId.equals(that.shippingId) : that.shippingId != null) return false;
        if (shippingName != null ? !shippingName.equals(that.shippingName) : that.shippingName != null) return false;
        if (shippingFee != null ? !shippingFee.equals(that.shippingFee) : that.shippingFee != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (consignee != null ? consignee.hashCode() : 0);
        result = 31 * result + (regionId != null ? regionId.hashCode() : 0);
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + (phoneTel != null ? phoneTel.hashCode() : 0);
        result = 31 * result + (phoneMob != null ? phoneMob.hashCode() : 0);
        result = 31 * result + (shippingId != null ? shippingId.hashCode() : 0);
        result = 31 * result + (shippingName != null ? shippingName.hashCode() : 0);
        result = 31 * result + (shippingFee != null ? shippingFee.hashCode() : 0);
        return result;
    }
}
