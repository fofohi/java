package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_friend", schema = "fenshang", catalog = "")
@IdClass(EcmFriendEntityPK.class)
public class EcmFriendEntity {
    private int ownerId;
    private int friendId;
    private String addTime;

    @Id
    @Column(name = "owner_id", nullable = false)
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Id
    @Column(name = "friend_id", nullable = false)
    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    @Basic
    @Column(name = "add_time", nullable = false, length = 10)
    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmFriendEntity that = (EcmFriendEntity) o;

        if (ownerId != that.ownerId) return false;
        if (friendId != that.friendId) return false;
        if (addTime != null ? !addTime.equals(that.addTime) : that.addTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ownerId;
        result = 31 * result + friendId;
        result = 31 * result + (addTime != null ? addTime.hashCode() : 0);
        return result;
    }
}
