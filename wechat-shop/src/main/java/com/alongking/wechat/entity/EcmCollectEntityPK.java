package com.alongking.wechat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by alongsea2 on 2017/1/8.
 */
public class EcmCollectEntityPK implements Serializable {
    private int userId;
    private String type;
    private int itemId;

    @Column(name = "user_id", nullable = false)
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "type", nullable = false, length = 10)
    @Id
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "item_id", nullable = false)
    @Id
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmCollectEntityPK that = (EcmCollectEntityPK) o;

        if (userId != that.userId) return false;
        if (itemId != that.itemId) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + itemId;
        return result;
    }
}
