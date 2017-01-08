package com.alongking.wechat.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_shipping", schema = "fenshang", catalog = "")
public class EcmShippingEntity {
    private int shippingId;
    private int storeId;
    private String shippingName;
    private String shippingDesc;
    private BigDecimal firstPrice;
    private BigDecimal stepPrice;
    private String codRegions;
    private byte enabled;
    private byte sortOrder;

    @Id
    @Column(name = "shipping_id", nullable = false)
    public int getShippingId() {
        return shippingId;
    }

    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
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
    @Column(name = "shipping_name", nullable = false, length = 100)
    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    @Basic
    @Column(name = "shipping_desc", nullable = true, length = 255)
    public String getShippingDesc() {
        return shippingDesc;
    }

    public void setShippingDesc(String shippingDesc) {
        this.shippingDesc = shippingDesc;
    }

    @Basic
    @Column(name = "first_price", nullable = false, precision = 2)
    public BigDecimal getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(BigDecimal firstPrice) {
        this.firstPrice = firstPrice;
    }

    @Basic
    @Column(name = "step_price", nullable = false, precision = 2)
    public BigDecimal getStepPrice() {
        return stepPrice;
    }

    public void setStepPrice(BigDecimal stepPrice) {
        this.stepPrice = stepPrice;
    }

    @Basic
    @Column(name = "cod_regions", nullable = true, length = -1)
    public String getCodRegions() {
        return codRegions;
    }

    public void setCodRegions(String codRegions) {
        this.codRegions = codRegions;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmShippingEntity that = (EcmShippingEntity) o;

        if (shippingId != that.shippingId) return false;
        if (storeId != that.storeId) return false;
        if (enabled != that.enabled) return false;
        if (sortOrder != that.sortOrder) return false;
        if (shippingName != null ? !shippingName.equals(that.shippingName) : that.shippingName != null) return false;
        if (shippingDesc != null ? !shippingDesc.equals(that.shippingDesc) : that.shippingDesc != null) return false;
        if (firstPrice != null ? !firstPrice.equals(that.firstPrice) : that.firstPrice != null) return false;
        if (stepPrice != null ? !stepPrice.equals(that.stepPrice) : that.stepPrice != null) return false;
        if (codRegions != null ? !codRegions.equals(that.codRegions) : that.codRegions != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shippingId;
        result = 31 * result + storeId;
        result = 31 * result + (shippingName != null ? shippingName.hashCode() : 0);
        result = 31 * result + (shippingDesc != null ? shippingDesc.hashCode() : 0);
        result = 31 * result + (firstPrice != null ? firstPrice.hashCode() : 0);
        result = 31 * result + (stepPrice != null ? stepPrice.hashCode() : 0);
        result = 31 * result + (codRegions != null ? codRegions.hashCode() : 0);
        result = 31 * result + (int) enabled;
        result = 31 * result + (int) sortOrder;
        return result;
    }
}
