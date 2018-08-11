package com.szh.zookeeper;


/**
 * @author sunzhuhuan
 */
public class ActUserRegisterDTO {
    private Long userId;
    private String traceId = "";
    //绑定手机号 --81，
    //绑定银行卡--82，
    //新人注册--86
    private Integer typeId;
    /**
     * 渠道id
     */
    private String entranceId;
    /**
     * 平台
     */
    private String platformId;

    private String mobilPhone;

    private String uuid;

    private String thirdId;

    private String thirdType;

    public String getThirdType() {
        return thirdType;
    }

    public void setThirdType(String thirdType) {
        this.thirdType = thirdType;
    }

    //渠道code
    private ClientRequestHeader header;

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getEntranceId() {
        return entranceId;
    }

    public void setEntranceId(String entranceId) {
        this.entranceId = entranceId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }


    public String getMobilPhone() {
        return mobilPhone;
    }

    public void setMobilPhone(String mobilPhone) {
        this.mobilPhone = mobilPhone;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    public ClientRequestHeader getHeader() {
        return header;
    }

    public void setHeader(ClientRequestHeader header) {
        this.header = header;
    }
}
