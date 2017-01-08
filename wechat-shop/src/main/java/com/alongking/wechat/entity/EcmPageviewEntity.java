package com.alongking.wechat.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_pageview", schema = "fenshang", catalog = "")
public class EcmPageviewEntity {
    private int recId;
    private int storeId;
    private Date viewDate;
    private int viewTimes;

    @Id
    @Column(name = "rec_id", nullable = false)
    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
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
    @Column(name = "view_date", nullable = false)
    public Date getViewDate() {
        return viewDate;
    }

    public void setViewDate(Date viewDate) {
        this.viewDate = viewDate;
    }

    @Basic
    @Column(name = "view_times", nullable = false)
    public int getViewTimes() {
        return viewTimes;
    }

    public void setViewTimes(int viewTimes) {
        this.viewTimes = viewTimes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmPageviewEntity that = (EcmPageviewEntity) o;

        if (recId != that.recId) return false;
        if (storeId != that.storeId) return false;
        if (viewTimes != that.viewTimes) return false;
        if (viewDate != null ? !viewDate.equals(that.viewDate) : that.viewDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recId;
        result = 31 * result + storeId;
        result = 31 * result + (viewDate != null ? viewDate.hashCode() : 0);
        result = 31 * result + viewTimes;
        return result;
    }
}
