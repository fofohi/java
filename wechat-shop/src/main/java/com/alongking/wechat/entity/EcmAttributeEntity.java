package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_attribute", schema = "fenshang", catalog = "")
public class EcmAttributeEntity {
    private int attrId;
    private String attrName;
    private String inputMode;
    private String defValue;

    @Id
    @Column(name = "attr_id", nullable = false)
    public int getAttrId() {
        return attrId;
    }

    public void setAttrId(int attrId) {
        this.attrId = attrId;
    }

    @Basic
    @Column(name = "attr_name", nullable = false, length = 60)
    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    @Basic
    @Column(name = "input_mode", nullable = false, length = 10)
    public String getInputMode() {
        return inputMode;
    }

    public void setInputMode(String inputMode) {
        this.inputMode = inputMode;
    }

    @Basic
    @Column(name = "def_value", nullable = true, length = 255)
    public String getDefValue() {
        return defValue;
    }

    public void setDefValue(String defValue) {
        this.defValue = defValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmAttributeEntity that = (EcmAttributeEntity) o;

        if (attrId != that.attrId) return false;
        if (attrName != null ? !attrName.equals(that.attrName) : that.attrName != null) return false;
        if (inputMode != null ? !inputMode.equals(that.inputMode) : that.inputMode != null) return false;
        if (defValue != null ? !defValue.equals(that.defValue) : that.defValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attrId;
        result = 31 * result + (attrName != null ? attrName.hashCode() : 0);
        result = 31 * result + (inputMode != null ? inputMode.hashCode() : 0);
        result = 31 * result + (defValue != null ? defValue.hashCode() : 0);
        return result;
    }
}
