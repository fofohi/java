package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_privilege", schema = "fenshang", catalog = "")
public class EcmPrivilegeEntity {
    private String privCode;
    private String privName;
    private String parentCode;
    private String owner;

    @Id
    @Column(name = "priv_code", nullable = false, length = 20)
    public String getPrivCode() {
        return privCode;
    }

    public void setPrivCode(String privCode) {
        this.privCode = privCode;
    }

    @Basic
    @Column(name = "priv_name", nullable = false, length = 60)
    public String getPrivName() {
        return privName;
    }

    public void setPrivName(String privName) {
        this.privName = privName;
    }

    @Basic
    @Column(name = "parent_code", nullable = true, length = 20)
    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    @Basic
    @Column(name = "owner", nullable = false, length = 10)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmPrivilegeEntity that = (EcmPrivilegeEntity) o;

        if (privCode != null ? !privCode.equals(that.privCode) : that.privCode != null) return false;
        if (privName != null ? !privName.equals(that.privName) : that.privName != null) return false;
        if (parentCode != null ? !parentCode.equals(that.parentCode) : that.parentCode != null) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = privCode != null ? privCode.hashCode() : 0;
        result = 31 * result + (privName != null ? privName.hashCode() : 0);
        result = 31 * result + (parentCode != null ? parentCode.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        return result;
    }
}
