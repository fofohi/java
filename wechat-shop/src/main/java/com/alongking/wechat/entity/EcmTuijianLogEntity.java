package com.alongking.wechat.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_tuijian_log", schema = "fenshang", catalog = "")
public class EcmTuijianLogEntity {
    private int id;
    private int userId;
    private int tuijianId;
    private BigDecimal price;
    private BigDecimal jifen;
    private int addTime;
    private String userName;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "tuijian_id", nullable = false)
    public int getTuijianId() {
        return tuijianId;
    }

    public void setTuijianId(int tuijianId) {
        this.tuijianId = tuijianId;
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
    @Column(name = "jifen", nullable = false, precision = 2)
    public BigDecimal getJifen() {
        return jifen;
    }

    public void setJifen(BigDecimal jifen) {
        this.jifen = jifen;
    }

    @Basic
    @Column(name = "add_time", nullable = false)
    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 255)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmTuijianLogEntity that = (EcmTuijianLogEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (tuijianId != that.tuijianId) return false;
        if (addTime != that.addTime) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (jifen != null ? !jifen.equals(that.jifen) : that.jifen != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + tuijianId;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (jifen != null ? jifen.hashCode() : 0);
        result = 31 * result + addTime;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }
}
