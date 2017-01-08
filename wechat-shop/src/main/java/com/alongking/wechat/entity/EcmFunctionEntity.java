package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_function", schema = "fenshang", catalog = "")
public class EcmFunctionEntity {
    private String funcCode;
    private String funcName;
    private String privileges;

    @Id
    @Column(name = "func_code", nullable = false, length = 20)
    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    @Basic
    @Column(name = "func_name", nullable = false, length = 60)
    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    @Basic
    @Column(name = "privileges", nullable = false, length = 255)
    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmFunctionEntity that = (EcmFunctionEntity) o;

        if (funcCode != null ? !funcCode.equals(that.funcCode) : that.funcCode != null) return false;
        if (funcName != null ? !funcName.equals(that.funcName) : that.funcName != null) return false;
        if (privileges != null ? !privileges.equals(that.privileges) : that.privileges != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = funcCode != null ? funcCode.hashCode() : 0;
        result = 31 * result + (funcName != null ? funcName.hashCode() : 0);
        result = 31 * result + (privileges != null ? privileges.hashCode() : 0);
        return result;
    }
}
