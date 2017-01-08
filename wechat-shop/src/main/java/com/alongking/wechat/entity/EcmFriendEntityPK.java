package com.alongking.wechat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by alongsea2 on 2017/1/8.
 */
public class EcmFriendEntityPK implements Serializable {
    private int ownerId;
    private int friendId;

    @Column(name = "owner_id", nullable = false)
    @Id
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Column(name = "friend_id", nullable = false)
    @Id
    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmFriendEntityPK that = (EcmFriendEntityPK) o;

        if (ownerId != that.ownerId) return false;
        if (friendId != that.friendId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ownerId;
        result = 31 * result + friendId;
        return result;
    }
}
