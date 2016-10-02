package dto;

/**
 * Created by dell on 2016/9/18.
 */
public class OrgDescription {
    private String fundType;
    private String managerOrgans;
    private String phone;
    private String webUrl;
    private String logNumber;

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getManagerOrgans() {
        return managerOrgans;
    }

    public void setManagerOrgans(String managerOrgans) {
        this.managerOrgans = managerOrgans;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getLogNumber() {
        return logNumber;
    }

    public void setLogNumber(String logNumber) {
        this.logNumber = logNumber;
    }
}
