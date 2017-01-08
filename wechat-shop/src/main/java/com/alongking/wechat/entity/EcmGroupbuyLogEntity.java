package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_groupbuy_log", schema = "fenshang", catalog = "")
@IdClass(EcmGroupbuyLogEntityPK.class)
public class EcmGroupbuyLogEntity {
    private int groupId;
    private int userId;
    private String userName;
    private short quantity;
    private String specQuantity;
    private String linkman;
    private String tel;
    private int orderId;
    private int addTime;

    @Id
    @Column(name = "group_id", nullable = false)
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 60)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "spec_quantity", nullable = false, length = -1)
    public String getSpecQuantity() {
        return specQuantity;
    }

    public void setSpecQuantity(String specQuantity) {
        this.specQuantity = specQuantity;
    }

    @Basic
    @Column(name = "linkman", nullable = false, length = 60)
    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
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
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "add_time", nullable = false)
    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmGroupbuyLogEntity that = (EcmGroupbuyLogEntity) o;

        if (groupId != that.groupId) return false;
        if (userId != that.userId) return false;
        if (quantity != that.quantity) return false;
        if (orderId != that.orderId) return false;
        if (addTime != that.addTime) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (specQuantity != null ? !specQuantity.equals(that.specQuantity) : that.specQuantity != null) return false;
        if (linkman != null ? !linkman.equals(that.linkman) : that.linkman != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId;
        result = 31 * result + userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (int) quantity;
        result = 31 * result + (specQuantity != null ? specQuantity.hashCode() : 0);
        result = 31 * result + (linkman != null ? linkman.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + orderId;
        result = 31 * result + addTime;
        return result;
    }
}
