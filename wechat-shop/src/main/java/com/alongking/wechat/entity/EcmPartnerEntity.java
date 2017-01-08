package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_partner", schema = "fenshang", catalog = "")
public class EcmPartnerEntity {
    private int partnerId;
    private int storeId;
    private String title;
    private String link;
    private String logo;
    private byte sortOrder;

    @Id
    @Column(name = "partner_id", nullable = false)
    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
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
    @Column(name = "title", nullable = false, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "link", nullable = false, length = 255)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "logo", nullable = true, length = 255)
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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

        EcmPartnerEntity that = (EcmPartnerEntity) o;

        if (partnerId != that.partnerId) return false;
        if (storeId != that.storeId) return false;
        if (sortOrder != that.sortOrder) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;
        if (logo != null ? !logo.equals(that.logo) : that.logo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = partnerId;
        result = 31 * result + storeId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (int) sortOrder;
        return result;
    }
}
