package com.alongking.wechat.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_goods_spec", schema = "fenshang", catalog = "")
public class EcmGoodsSpecEntity {
    private int specId;
    private int goodsId;
    private String spec1;
    private String spec2;
    private String colorRgb;
    private BigDecimal price;
    private int stock;
    private String sku;

    @Id
    @Column(name = "spec_id", nullable = false)
    public int getSpecId() {
        return specId;
    }

    public void setSpecId(int specId) {
        this.specId = specId;
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
    @Column(name = "spec_1", nullable = false, length = 60)
    public String getSpec1() {
        return spec1;
    }

    public void setSpec1(String spec1) {
        this.spec1 = spec1;
    }

    @Basic
    @Column(name = "spec_2", nullable = false, length = 60)
    public String getSpec2() {
        return spec2;
    }

    public void setSpec2(String spec2) {
        this.spec2 = spec2;
    }

    @Basic
    @Column(name = "color_rgb", nullable = false, length = 7)
    public String getColorRgb() {
        return colorRgb;
    }

    public void setColorRgb(String colorRgb) {
        this.colorRgb = colorRgb;
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
    @Column(name = "stock", nullable = false)
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Basic
    @Column(name = "sku", nullable = false, length = 60)
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmGoodsSpecEntity that = (EcmGoodsSpecEntity) o;

        if (specId != that.specId) return false;
        if (goodsId != that.goodsId) return false;
        if (stock != that.stock) return false;
        if (spec1 != null ? !spec1.equals(that.spec1) : that.spec1 != null) return false;
        if (spec2 != null ? !spec2.equals(that.spec2) : that.spec2 != null) return false;
        if (colorRgb != null ? !colorRgb.equals(that.colorRgb) : that.colorRgb != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (sku != null ? !sku.equals(that.sku) : that.sku != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = specId;
        result = 31 * result + goodsId;
        result = 31 * result + (spec1 != null ? spec1.hashCode() : 0);
        result = 31 * result + (spec2 != null ? spec2.hashCode() : 0);
        result = 31 * result + (colorRgb != null ? colorRgb.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + stock;
        result = 31 * result + (sku != null ? sku.hashCode() : 0);
        return result;
    }
}
