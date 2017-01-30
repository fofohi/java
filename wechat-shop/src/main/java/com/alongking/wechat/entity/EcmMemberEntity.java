package com.alongking.wechat.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_member", schema = "fenshang", catalog = "")
public class EcmMemberEntity {
    private int userId;
    private String userName;
    private String email = "";
    private String password;
    private String realName;
    private byte gender = 0;
    private Date birthday = new Date(System.currentTimeMillis());
    private String phoneTel = "";
    private String phoneMob = "";
    private String imQq = "";
    private String imMsn = "";
    private String imSkype = "";
    private String imYahoo = "";
    private String imAliww = "";
    private Integer regTime;
    private Integer lastLogin;
    private String lastIp;
    private int logins = 1;
    private byte ugrade;
    private String portrait;
    private int outerId = 0;
    private String activation = "";
    private String feedConfig = "";
    private BigDecimal money = new BigDecimal(0);
    private BigDecimal jifen = new BigDecimal(0);
    private Integer tuijianId = 0;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 60)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 60)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "real_name", nullable = true, length = 60)
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "gender", nullable = false)
    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "phone_tel", nullable = true, length = 60)
    public String getPhoneTel() {
        return phoneTel;
    }

    public void setPhoneTel(String phoneTel) {
        this.phoneTel = phoneTel;
    }

    @Basic
    @Column(name = "phone_mob", nullable = true, length = 60)
    public String getPhoneMob() {
        return phoneMob;
    }

    public void setPhoneMob(String phoneMob) {
        this.phoneMob = phoneMob;
    }

    @Basic
    @Column(name = "im_qq", nullable = true, length = 60)
    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    @Basic
    @Column(name = "im_msn", nullable = true, length = 60)
    public String getImMsn() {
        return imMsn;
    }

    public void setImMsn(String imMsn) {
        this.imMsn = imMsn;
    }

    @Basic
    @Column(name = "im_skype", nullable = true, length = 60)
    public String getImSkype() {
        return imSkype;
    }

    public void setImSkype(String imSkype) {
        this.imSkype = imSkype;
    }

    @Basic
    @Column(name = "im_yahoo", nullable = true, length = 60)
    public String getImYahoo() {
        return imYahoo;
    }

    public void setImYahoo(String imYahoo) {
        this.imYahoo = imYahoo;
    }

    @Basic
    @Column(name = "im_aliww", nullable = true, length = 60)
    public String getImAliww() {
        return imAliww;
    }

    public void setImAliww(String imAliww) {
        this.imAliww = imAliww;
    }

    @Basic
    @Column(name = "reg_time", nullable = true)
    public Integer getRegTime() {
        return regTime;
    }

    public void setRegTime(Integer regTime) {
        this.regTime = regTime;
    }

    @Basic
    @Column(name = "last_login", nullable = true)
    public Integer getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Integer lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Basic
    @Column(name = "last_ip", nullable = true, length = 15)
    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    @Basic
    @Column(name = "logins", nullable = false)
    public int getLogins() {
        return logins;
    }

    public void setLogins(int logins) {
        this.logins = logins;
    }

    @Basic
    @Column(name = "ugrade", nullable = false)
    public byte getUgrade() {
        return ugrade;
    }

    public void setUgrade(byte ugrade) {
        this.ugrade = ugrade;
    }

    @Basic
    @Column(name = "portrait", nullable = true, length = 255)
    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    @Basic
    @Column(name = "outer_id", nullable = false)
    public int getOuterId() {
        return outerId;
    }

    public void setOuterId(int outerId) {
        this.outerId = outerId;
    }

    @Basic
    @Column(name = "activation", nullable = true, length = 60)
    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    @Basic
    @Column(name = "feed_config", nullable = false, length = -1)
    public String getFeedConfig() {
        return feedConfig;
    }

    public void setFeedConfig(String feedConfig) {
        this.feedConfig = feedConfig;
    }

    @Basic
    @Column(name = "money", nullable = true, precision = 2)
    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Basic
    @Column(name = "jifen", nullable = true, precision = 2)
    public BigDecimal getJifen() {
        return jifen;
    }

    public void setJifen(BigDecimal jifen) {
        this.jifen = jifen;
    }

    @Basic
    @Column(name = "tuijian_id", nullable = true)
    public Integer getTuijianId() {
        return tuijianId;
    }

    public void setTuijianId(Integer tuijianId) {
        this.tuijianId = tuijianId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmMemberEntity that = (EcmMemberEntity) o;

        if (userId != that.userId) return false;
        if (gender != that.gender) return false;
        if (logins != that.logins) return false;
        if (ugrade != that.ugrade) return false;
        if (outerId != that.outerId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (phoneTel != null ? !phoneTel.equals(that.phoneTel) : that.phoneTel != null) return false;
        if (phoneMob != null ? !phoneMob.equals(that.phoneMob) : that.phoneMob != null) return false;
        if (imQq != null ? !imQq.equals(that.imQq) : that.imQq != null) return false;
        if (imMsn != null ? !imMsn.equals(that.imMsn) : that.imMsn != null) return false;
        if (imSkype != null ? !imSkype.equals(that.imSkype) : that.imSkype != null) return false;
        if (imYahoo != null ? !imYahoo.equals(that.imYahoo) : that.imYahoo != null) return false;
        if (imAliww != null ? !imAliww.equals(that.imAliww) : that.imAliww != null) return false;
        if (regTime != null ? !regTime.equals(that.regTime) : that.regTime != null) return false;
        if (lastLogin != null ? !lastLogin.equals(that.lastLogin) : that.lastLogin != null) return false;
        if (lastIp != null ? !lastIp.equals(that.lastIp) : that.lastIp != null) return false;
        if (portrait != null ? !portrait.equals(that.portrait) : that.portrait != null) return false;
        if (activation != null ? !activation.equals(that.activation) : that.activation != null) return false;
        if (feedConfig != null ? !feedConfig.equals(that.feedConfig) : that.feedConfig != null) return false;
        if (money != null ? !money.equals(that.money) : that.money != null) return false;
        if (jifen != null ? !jifen.equals(that.jifen) : that.jifen != null) return false;
        if (tuijianId != null ? !tuijianId.equals(that.tuijianId) : that.tuijianId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (int) gender;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (phoneTel != null ? phoneTel.hashCode() : 0);
        result = 31 * result + (phoneMob != null ? phoneMob.hashCode() : 0);
        result = 31 * result + (imQq != null ? imQq.hashCode() : 0);
        result = 31 * result + (imMsn != null ? imMsn.hashCode() : 0);
        result = 31 * result + (imSkype != null ? imSkype.hashCode() : 0);
        result = 31 * result + (imYahoo != null ? imYahoo.hashCode() : 0);
        result = 31 * result + (imAliww != null ? imAliww.hashCode() : 0);
        result = 31 * result + (regTime != null ? regTime.hashCode() : 0);
        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
        result = 31 * result + (lastIp != null ? lastIp.hashCode() : 0);
        result = 31 * result + logins;
        result = 31 * result + (int) ugrade;
        result = 31 * result + (portrait != null ? portrait.hashCode() : 0);
        result = 31 * result + outerId;
        result = 31 * result + (activation != null ? activation.hashCode() : 0);
        result = 31 * result + (feedConfig != null ? feedConfig.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + (jifen != null ? jifen.hashCode() : 0);
        result = 31 * result + (tuijianId != null ? tuijianId.hashCode() : 0);
        return result;
    }
}
