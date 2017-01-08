package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_module", schema = "fenshang", catalog = "")
public class EcmModuleEntity {
    private String moduleId;
    private String moduleName;
    private String moduleVersion;
    private String moduleDesc;
    private String moduleConfig;
    private byte enabled;

    @Id
    @Column(name = "module_id", nullable = false, length = 30)
    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    @Basic
    @Column(name = "module_name", nullable = false, length = 100)
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Basic
    @Column(name = "module_version", nullable = false, length = 5)
    public String getModuleVersion() {
        return moduleVersion;
    }

    public void setModuleVersion(String moduleVersion) {
        this.moduleVersion = moduleVersion;
    }

    @Basic
    @Column(name = "module_desc", nullable = false, length = -1)
    public String getModuleDesc() {
        return moduleDesc;
    }

    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
    }

    @Basic
    @Column(name = "module_config", nullable = false, length = -1)
    public String getModuleConfig() {
        return moduleConfig;
    }

    public void setModuleConfig(String moduleConfig) {
        this.moduleConfig = moduleConfig;
    }

    @Basic
    @Column(name = "enabled", nullable = false)
    public byte getEnabled() {
        return enabled;
    }

    public void setEnabled(byte enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmModuleEntity that = (EcmModuleEntity) o;

        if (enabled != that.enabled) return false;
        if (moduleId != null ? !moduleId.equals(that.moduleId) : that.moduleId != null) return false;
        if (moduleName != null ? !moduleName.equals(that.moduleName) : that.moduleName != null) return false;
        if (moduleVersion != null ? !moduleVersion.equals(that.moduleVersion) : that.moduleVersion != null)
            return false;
        if (moduleDesc != null ? !moduleDesc.equals(that.moduleDesc) : that.moduleDesc != null) return false;
        if (moduleConfig != null ? !moduleConfig.equals(that.moduleConfig) : that.moduleConfig != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = moduleId != null ? moduleId.hashCode() : 0;
        result = 31 * result + (moduleName != null ? moduleName.hashCode() : 0);
        result = 31 * result + (moduleVersion != null ? moduleVersion.hashCode() : 0);
        result = 31 * result + (moduleDesc != null ? moduleDesc.hashCode() : 0);
        result = 31 * result + (moduleConfig != null ? moduleConfig.hashCode() : 0);
        result = 31 * result + (int) enabled;
        return result;
    }
}
