package com.alongking.wechat.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_store", schema = "fenshang", catalog = "")
public class EcmStoreEntity {
    private int storeId;
    private String storeName;
    private String ownerName;
    private String ownerCard;
    private Integer regionId;
    private String regionName;
    private String address;
    private String zipcode;
    private String tel;
    private byte sgrade;
    private String applyRemark;
    private int creditValue;
    private BigDecimal praiseRate;
    private String domain;
    private byte state;
    private String closeReason;
    private Integer addTime;
    private int endTime;
    private String certification;
    private short sortOrder;
    private byte recommended;
    private String theme;
    private String storeBanner;
    private String storeLogo;
    private String description;
    private String image1;
    private String image2;
    private String image3;
    private String imQq;
    private String imWw;
    private String imMsn;
    private byte enableGroupbuy;
    private byte enableRadar;
    private String storeCode;
    private String storeNewImages;
    private String storeRecommendImages;
    private String storeHotImages;

    @Id
    @Column(name = "store_id", nullable = false)
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "store_name", nullable = false, length = 100)
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Basic
    @Column(name = "owner_name", nullable = false, length = 60)
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Basic
    @Column(name = "owner_card", nullable = false, length = 60)
    public String getOwnerCard() {
        return ownerCard;
    }

    public void setOwnerCard(String ownerCard) {
        this.ownerCard = ownerCard;
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
    @Column(name = "region_name", nullable = true, length = 100)
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "zipcode", nullable = false, length = 20)
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "tel", nullable = false, length = 60)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "sgrade", nullable = false)
    public byte getSgrade() {
        return sgrade;
    }

    public void setSgrade(byte sgrade) {
        this.sgrade = sgrade;
    }

    @Basic
    @Column(name = "apply_remark", nullable = false, length = 255)
    public String getApplyRemark() {
        return applyRemark;
    }

    public void setApplyRemark(String applyRemark) {
        this.applyRemark = applyRemark;
    }

    @Basic
    @Column(name = "credit_value", nullable = false)
    public int getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(int creditValue) {
        this.creditValue = creditValue;
    }

    @Basic
    @Column(name = "praise_rate", nullable = false, precision = 2)
    public BigDecimal getPraiseRate() {
        return praiseRate;
    }

    public void setPraiseRate(BigDecimal praiseRate) {
        this.praiseRate = praiseRate;
    }

    @Basic
    @Column(name = "domain", nullable = true, length = 60)
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    @Basic
    @Column(name = "close_reason", nullable = false, length = 255)
    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    @Basic
    @Column(name = "add_time", nullable = true)
    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
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
    @Column(name = "certification", nullable = true, length = 255)
    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    @Basic
    @Column(name = "sort_order", nullable = false)
    public short getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(short sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Basic
    @Column(name = "recommended", nullable = false)
    public byte getRecommended() {
        return recommended;
    }

    public void setRecommended(byte recommended) {
        this.recommended = recommended;
    }

    @Basic
    @Column(name = "theme", nullable = false, length = 60)
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Basic
    @Column(name = "store_banner", nullable = true, length = 255)
    public String getStoreBanner() {
        return storeBanner;
    }

    public void setStoreBanner(String storeBanner) {
        this.storeBanner = storeBanner;
    }

    @Basic
    @Column(name = "store_logo", nullable = true, length = 255)
    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "image_1", nullable = false, length = 255)
    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    @Basic
    @Column(name = "image_2", nullable = false, length = 255)
    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    @Basic
    @Column(name = "image_3", nullable = false, length = 255)
    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    @Basic
    @Column(name = "im_qq", nullable = false, length = 60)
    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    @Basic
    @Column(name = "im_ww", nullable = false, length = 60)
    public String getImWw() {
        return imWw;
    }

    public void setImWw(String imWw) {
        this.imWw = imWw;
    }

    @Basic
    @Column(name = "im_msn", nullable = false, length = 60)
    public String getImMsn() {
        return imMsn;
    }

    public void setImMsn(String imMsn) {
        this.imMsn = imMsn;
    }

    @Basic
    @Column(name = "enable_groupbuy", nullable = false)
    public byte getEnableGroupbuy() {
        return enableGroupbuy;
    }

    public void setEnableGroupbuy(byte enableGroupbuy) {
        this.enableGroupbuy = enableGroupbuy;
    }

    @Basic
    @Column(name = "enable_radar", nullable = false)
    public byte getEnableRadar() {
        return enableRadar;
    }

    public void setEnableRadar(byte enableRadar) {
        this.enableRadar = enableRadar;
    }

    @Basic
    @Column(name = "store_code", nullable = true, length = 255)
    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    @Basic
    @Column(name = "store_new_images", nullable = true, length = 255)
    public String getStoreNewImages() {
        return storeNewImages;
    }

    public void setStoreNewImages(String storeNewImages) {
        this.storeNewImages = storeNewImages;
    }

    @Basic
    @Column(name = "store_recommend_images", nullable = true, length = 255)
    public String getStoreRecommendImages() {
        return storeRecommendImages;
    }

    public void setStoreRecommendImages(String storeRecommendImages) {
        this.storeRecommendImages = storeRecommendImages;
    }

    @Basic
    @Column(name = "store_hot_images", nullable = true, length = 255)
    public String getStoreHotImages() {
        return storeHotImages;
    }

    public void setStoreHotImages(String storeHotImages) {
        this.storeHotImages = storeHotImages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmStoreEntity that = (EcmStoreEntity) o;

        if (storeId != that.storeId) return false;
        if (sgrade != that.sgrade) return false;
        if (creditValue != that.creditValue) return false;
        if (state != that.state) return false;
        if (endTime != that.endTime) return false;
        if (sortOrder != that.sortOrder) return false;
        if (recommended != that.recommended) return false;
        if (enableGroupbuy != that.enableGroupbuy) return false;
        if (enableRadar != that.enableRadar) return false;
        if (storeName != null ? !storeName.equals(that.storeName) : that.storeName != null) return false;
        if (ownerName != null ? !ownerName.equals(that.ownerName) : that.ownerName != null) return false;
        if (ownerCard != null ? !ownerCard.equals(that.ownerCard) : that.ownerCard != null) return false;
        if (regionId != null ? !regionId.equals(that.regionId) : that.regionId != null) return false;
        if (regionName != null ? !regionName.equals(that.regionName) : that.regionName != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (zipcode != null ? !zipcode.equals(that.zipcode) : that.zipcode != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (applyRemark != null ? !applyRemark.equals(that.applyRemark) : that.applyRemark != null) return false;
        if (praiseRate != null ? !praiseRate.equals(that.praiseRate) : that.praiseRate != null) return false;
        if (domain != null ? !domain.equals(that.domain) : that.domain != null) return false;
        if (closeReason != null ? !closeReason.equals(that.closeReason) : that.closeReason != null) return false;
        if (addTime != null ? !addTime.equals(that.addTime) : that.addTime != null) return false;
        if (certification != null ? !certification.equals(that.certification) : that.certification != null)
            return false;
        if (theme != null ? !theme.equals(that.theme) : that.theme != null) return false;
        if (storeBanner != null ? !storeBanner.equals(that.storeBanner) : that.storeBanner != null) return false;
        if (storeLogo != null ? !storeLogo.equals(that.storeLogo) : that.storeLogo != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (image1 != null ? !image1.equals(that.image1) : that.image1 != null) return false;
        if (image2 != null ? !image2.equals(that.image2) : that.image2 != null) return false;
        if (image3 != null ? !image3.equals(that.image3) : that.image3 != null) return false;
        if (imQq != null ? !imQq.equals(that.imQq) : that.imQq != null) return false;
        if (imWw != null ? !imWw.equals(that.imWw) : that.imWw != null) return false;
        if (imMsn != null ? !imMsn.equals(that.imMsn) : that.imMsn != null) return false;
        if (storeCode != null ? !storeCode.equals(that.storeCode) : that.storeCode != null) return false;
        if (storeNewImages != null ? !storeNewImages.equals(that.storeNewImages) : that.storeNewImages != null)
            return false;
        if (storeRecommendImages != null ? !storeRecommendImages.equals(that.storeRecommendImages) : that.storeRecommendImages != null)
            return false;
        if (storeHotImages != null ? !storeHotImages.equals(that.storeHotImages) : that.storeHotImages != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = storeId;
        result = 31 * result + (storeName != null ? storeName.hashCode() : 0);
        result = 31 * result + (ownerName != null ? ownerName.hashCode() : 0);
        result = 31 * result + (ownerCard != null ? ownerCard.hashCode() : 0);
        result = 31 * result + (regionId != null ? regionId.hashCode() : 0);
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (int) sgrade;
        result = 31 * result + (applyRemark != null ? applyRemark.hashCode() : 0);
        result = 31 * result + creditValue;
        result = 31 * result + (praiseRate != null ? praiseRate.hashCode() : 0);
        result = 31 * result + (domain != null ? domain.hashCode() : 0);
        result = 31 * result + (int) state;
        result = 31 * result + (closeReason != null ? closeReason.hashCode() : 0);
        result = 31 * result + (addTime != null ? addTime.hashCode() : 0);
        result = 31 * result + endTime;
        result = 31 * result + (certification != null ? certification.hashCode() : 0);
        result = 31 * result + (int) sortOrder;
        result = 31 * result + (int) recommended;
        result = 31 * result + (theme != null ? theme.hashCode() : 0);
        result = 31 * result + (storeBanner != null ? storeBanner.hashCode() : 0);
        result = 31 * result + (storeLogo != null ? storeLogo.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (image1 != null ? image1.hashCode() : 0);
        result = 31 * result + (image2 != null ? image2.hashCode() : 0);
        result = 31 * result + (image3 != null ? image3.hashCode() : 0);
        result = 31 * result + (imQq != null ? imQq.hashCode() : 0);
        result = 31 * result + (imWw != null ? imWw.hashCode() : 0);
        result = 31 * result + (imMsn != null ? imMsn.hashCode() : 0);
        result = 31 * result + (int) enableGroupbuy;
        result = 31 * result + (int) enableRadar;
        result = 31 * result + (storeCode != null ? storeCode.hashCode() : 0);
        result = 31 * result + (storeNewImages != null ? storeNewImages.hashCode() : 0);
        result = 31 * result + (storeRecommendImages != null ? storeRecommendImages.hashCode() : 0);
        result = 31 * result + (storeHotImages != null ? storeHotImages.hashCode() : 0);
        return result;
    }
}
