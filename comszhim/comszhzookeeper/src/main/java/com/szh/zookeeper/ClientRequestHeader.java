package com.szh.zookeeper;

public class ClientRequestHeader {
    private String platformVersion;
    private String platformCode;
    private String cmdID;
    private String cmdName = "app_zz";
    private String token;
    private String appVersion;
    private String userID;
    private String userGuid;
    private String userType;
    private String uuid;
    private String ts;
    private String traceID;
    private String action;
    private String phoneName;
    private String sign;
    private String fromCode;
    private double lng;
    private double lat;
    private int chooseType;
    private String ip;

    public ClientRequestHeader() {
    }

    public String getPlatformVersion() {
        return this.platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getPlatformCode() {
        return this.platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }

    public String getCmdID() {
        return this.cmdID;
    }

    public void setCmdID(String cmdID) {
        this.cmdID = cmdID;
    }

    public String getCmdName() {
        return this.cmdName;
    }

    public void setCmdName(String cmdName) {
        this.cmdName = cmdName;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserGuid() {
        return this.userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTs() {
        return this.ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getTraceID() {
        return this.traceID;
    }

    public void setTraceID(String traceID) {
        this.traceID = traceID;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPhoneName() {
        return this.phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getFromCode() {
        return this.fromCode;
    }

    public void setFromCode(String fromCode) {
        this.fromCode = fromCode;
    }

    public double getLng() {
        return this.lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return this.lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getChooseType() {
        return this.chooseType;
    }

    public void setChooseType(int chooseType) {
        this.chooseType = chooseType;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
