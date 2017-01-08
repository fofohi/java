package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_article", schema = "fenshang", catalog = "")
public class EcmArticleEntity {
    private int articleId;
    private String code;
    private String title;
    private int cateId;
    private int storeId;
    private String link;
    private String content;
    private byte sortOrder;
    private byte ifShow;
    private Integer addTime;

    @Id
    @Column(name = "article_id", nullable = false)
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 20)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    @Column(name = "cate_id", nullable = false)
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
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
    @Column(name = "link", nullable = true, length = 255)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    @Column(name = "if_show", nullable = false)
    public byte getIfShow() {
        return ifShow;
    }

    public void setIfShow(byte ifShow) {
        this.ifShow = ifShow;
    }

    @Basic
    @Column(name = "add_time", nullable = true)
    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmArticleEntity that = (EcmArticleEntity) o;

        if (articleId != that.articleId) return false;
        if (cateId != that.cateId) return false;
        if (storeId != that.storeId) return false;
        if (sortOrder != that.sortOrder) return false;
        if (ifShow != that.ifShow) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (addTime != null ? !addTime.equals(that.addTime) : that.addTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = articleId;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + cateId;
        result = 31 * result + storeId;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (int) sortOrder;
        result = 31 * result + (int) ifShow;
        result = 31 * result + (addTime != null ? addTime.hashCode() : 0);
        return result;
    }
}
