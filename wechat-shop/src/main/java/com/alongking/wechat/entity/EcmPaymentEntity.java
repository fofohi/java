package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_payment", schema = "fenshang", catalog = "")
public class EcmPaymentEntity {
    private int paymentId;
    private int storeId;
    private String paymentCode;
    private String paymentName;
    private String paymentDesc;
    private String config;
    private byte isOnline;
    private byte enabled;
    private byte sortOrder;
    private String bankImages;

    @Id
    @Column(name = "payment_id", nullable = false)
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
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
    @Column(name = "payment_code", nullable = false, length = 20)
    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    @Basic
    @Column(name = "payment_name", nullable = false, length = 100)
    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    @Basic
    @Column(name = "payment_desc", nullable = true, length = 255)
    public String getPaymentDesc() {
        return paymentDesc;
    }

    public void setPaymentDesc(String paymentDesc) {
        this.paymentDesc = paymentDesc;
    }

    @Basic
    @Column(name = "config", nullable = true, length = -1)
    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    @Basic
    @Column(name = "is_online", nullable = false)
    public byte getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(byte isOnline) {
        this.isOnline = isOnline;
    }

    @Basic
    @Column(name = "enabled", nullable = false)
    public byte getEnabled() {
        return enabled;
    }

    public void setEnabled(byte enabled) {
        this.enabled = enabled;
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
    @Column(name = "bank_images", nullable = true, length = 255)
    public String getBankImages() {
        return bankImages;
    }

    public void setBankImages(String bankImages) {
        this.bankImages = bankImages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmPaymentEntity that = (EcmPaymentEntity) o;

        if (paymentId != that.paymentId) return false;
        if (storeId != that.storeId) return false;
        if (isOnline != that.isOnline) return false;
        if (enabled != that.enabled) return false;
        if (sortOrder != that.sortOrder) return false;
        if (paymentCode != null ? !paymentCode.equals(that.paymentCode) : that.paymentCode != null) return false;
        if (paymentName != null ? !paymentName.equals(that.paymentName) : that.paymentName != null) return false;
        if (paymentDesc != null ? !paymentDesc.equals(that.paymentDesc) : that.paymentDesc != null) return false;
        if (config != null ? !config.equals(that.config) : that.config != null) return false;
        if (bankImages != null ? !bankImages.equals(that.bankImages) : that.bankImages != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paymentId;
        result = 31 * result + storeId;
        result = 31 * result + (paymentCode != null ? paymentCode.hashCode() : 0);
        result = 31 * result + (paymentName != null ? paymentName.hashCode() : 0);
        result = 31 * result + (paymentDesc != null ? paymentDesc.hashCode() : 0);
        result = 31 * result + (config != null ? config.hashCode() : 0);
        result = 31 * result + (int) isOnline;
        result = 31 * result + (int) enabled;
        result = 31 * result + (int) sortOrder;
        result = 31 * result + (bankImages != null ? bankImages.hashCode() : 0);
        return result;
    }
}
