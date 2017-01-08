package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_order_log", schema = "fenshang", catalog = "")
public class EcmOrderLogEntity {
    private int logId;
    private int orderId;
    private String operator;
    private String orderStatus;
    private String changedStatus;
    private String remark;
    private int logTime;

    @Id
    @Column(name = "log_id", nullable = false)
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    @Basic
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "operator", nullable = false, length = 60)
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Basic
    @Column(name = "order_status", nullable = false, length = 60)
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "changed_status", nullable = false, length = 60)
    public String getChangedStatus() {
        return changedStatus;
    }

    public void setChangedStatus(String changedStatus) {
        this.changedStatus = changedStatus;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "log_time", nullable = false)
    public int getLogTime() {
        return logTime;
    }

    public void setLogTime(int logTime) {
        this.logTime = logTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmOrderLogEntity that = (EcmOrderLogEntity) o;

        if (logId != that.logId) return false;
        if (orderId != that.orderId) return false;
        if (logTime != that.logTime) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (orderStatus != null ? !orderStatus.equals(that.orderStatus) : that.orderStatus != null) return false;
        if (changedStatus != null ? !changedStatus.equals(that.changedStatus) : that.changedStatus != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logId;
        result = 31 * result + orderId;
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (changedStatus != null ? changedStatus.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + logTime;
        return result;
    }
}
