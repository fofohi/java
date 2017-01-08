package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_address", schema = "fenshang", catalog = "")
public class EcmAddressEntity {
    private int addrId;
    private int userId;
    private String consignee;
    private Integer regionId;
    private String regionName;
    private String address;
    private String zipcode;
    private String phoneTel;
    private String phoneMob;

    @Id
    @Column(name = "addr_id", nullable = false)
    public int getAddrId() {
        return addrId;
    }

    public void setAddrId(int addrId) {
        this.addrId = addrId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmAddressEntity that = (EcmAddressEntity) o;

        if (addrId != that.addrId) return false;
        if (userId != that.userId) return false;
        if (consignee != null ? !consignee.equals(that.consignee) : that.consignee != null) return false;
        if (regionId != null ? !regionId.equals(that.regionId) : that.regionId != null) return false;
        if (regionName != null ? !regionName.equals(that.regionName) : that.regionName != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (zipcode != null ? !zipcode.equals(that.zipcode) : that.zipcode != null) return false;
        if (phoneTel != null ? !phoneTel.equals(that.phoneTel) : that.phoneTel != null) return false;
        if (phoneMob != null ? !phoneMob.equals(that.phoneMob) : that.phoneMob != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addrId;
        result = 31 * result + userId;
        result = 31 * result + (consignee != null ? consignee.hashCode() : 0);
        result = 31 * result + (regionId != null ? regionId.hashCode() : 0);
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + (phoneTel != null ? phoneTel.hashCode() : 0);
        result = 31 * result + (phoneMob != null ? phoneMob.hashCode() : 0);
        return result;
    }
}
