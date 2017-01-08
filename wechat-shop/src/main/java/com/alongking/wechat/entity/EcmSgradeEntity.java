package com.alongking.wechat.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_sgrade", schema = "fenshang", catalog = "")
public class EcmSgradeEntity {
    private byte gradeId;
    private String gradeName;
    private int goodsLimit;
    private int spaceLimit;
    private int skinLimit;
    private String charge;
    private byte needConfirm;
    private String description;
    private String functions;
    private String skins;
    private byte sortOrder;
    private BigDecimal price;

    @Id
    @Column(name = "grade_id", nullable = false)
    public byte getGradeId() {
        return gradeId;
    }

    public void setGradeId(byte gradeId) {
        this.gradeId = gradeId;
    }

    @Basic
    @Column(name = "grade_name", nullable = false, length = 60)
    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    @Basic
    @Column(name = "goods_limit", nullable = false)
    public int getGoodsLimit() {
        return goodsLimit;
    }

    public void setGoodsLimit(int goodsLimit) {
        this.goodsLimit = goodsLimit;
    }

    @Basic
    @Column(name = "space_limit", nullable = false)
    public int getSpaceLimit() {
        return spaceLimit;
    }

    public void setSpaceLimit(int spaceLimit) {
        this.spaceLimit = spaceLimit;
    }

    @Basic
    @Column(name = "skin_limit", nullable = false)
    public int getSkinLimit() {
        return skinLimit;
    }

    public void setSkinLimit(int skinLimit) {
        this.skinLimit = skinLimit;
    }

    @Basic
    @Column(name = "charge", nullable = false, length = 100)
    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    @Basic
    @Column(name = "need_confirm", nullable = false)
    public byte getNeedConfirm() {
        return needConfirm;
    }

    public void setNeedConfirm(byte needConfirm) {
        this.needConfirm = needConfirm;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "functions", nullable = true, length = 255)
    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    @Basic
    @Column(name = "skins", nullable = false, length = -1)
    public String getSkins() {
        return skins;
    }

    public void setSkins(String skins) {
        this.skins = skins;
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
    @Column(name = "price", nullable = false, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmSgradeEntity that = (EcmSgradeEntity) o;

        if (gradeId != that.gradeId) return false;
        if (goodsLimit != that.goodsLimit) return false;
        if (spaceLimit != that.spaceLimit) return false;
        if (skinLimit != that.skinLimit) return false;
        if (needConfirm != that.needConfirm) return false;
        if (sortOrder != that.sortOrder) return false;
        if (gradeName != null ? !gradeName.equals(that.gradeName) : that.gradeName != null) return false;
        if (charge != null ? !charge.equals(that.charge) : that.charge != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (functions != null ? !functions.equals(that.functions) : that.functions != null) return false;
        if (skins != null ? !skins.equals(that.skins) : that.skins != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) gradeId;
        result = 31 * result + (gradeName != null ? gradeName.hashCode() : 0);
        result = 31 * result + goodsLimit;
        result = 31 * result + spaceLimit;
        result = 31 * result + skinLimit;
        result = 31 * result + (charge != null ? charge.hashCode() : 0);
        result = 31 * result + (int) needConfirm;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (functions != null ? functions.hashCode() : 0);
        result = 31 * result + (skins != null ? skins.hashCode() : 0);
        result = 31 * result + (int) sortOrder;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
