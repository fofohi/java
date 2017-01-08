package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_goods_statistics", schema = "fenshang", catalog = "")
public class EcmGoodsStatisticsEntity {
    private int goodsId;
    private int views;
    private int collects;
    private int carts;
    private int orders;
    private int sales;
    private int comments;

    @Id
    @Column(name = "goods_id", nullable = false)
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "views", nullable = false)
    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Basic
    @Column(name = "collects", nullable = false)
    public int getCollects() {
        return collects;
    }

    public void setCollects(int collects) {
        this.collects = collects;
    }

    @Basic
    @Column(name = "carts", nullable = false)
    public int getCarts() {
        return carts;
    }

    public void setCarts(int carts) {
        this.carts = carts;
    }

    @Basic
    @Column(name = "orders", nullable = false)
    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    @Basic
    @Column(name = "sales", nullable = false)
    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Basic
    @Column(name = "comments", nullable = false)
    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmGoodsStatisticsEntity that = (EcmGoodsStatisticsEntity) o;

        if (goodsId != that.goodsId) return false;
        if (views != that.views) return false;
        if (collects != that.collects) return false;
        if (carts != that.carts) return false;
        if (orders != that.orders) return false;
        if (sales != that.sales) return false;
        if (comments != that.comments) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = goodsId;
        result = 31 * result + views;
        result = 31 * result + collects;
        result = 31 * result + carts;
        result = 31 * result + orders;
        result = 31 * result + sales;
        result = 31 * result + comments;
        return result;
    }
}
