package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_keyword", schema = "fenshang", catalog = "")
public class EcmKeywordEntity {
    private int kid;
    private String kename;
    private String kecontent;
    private byte type;
    private String kyword;
    private String titles;
    private String imageinfo;
    private String linkinfo;
    private Byte ismess;
    private Byte isfollow;
    private Byte iskey;
    private int userId;
    private String token;

    @Id
    @Column(name = "kid", nullable = false)
    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    @Basic
    @Column(name = "kename", nullable = true, length = 300)
    public String getKename() {
        return kename;
    }

    public void setKename(String kename) {
        this.kename = kename;
    }

    @Basic
    @Column(name = "kecontent", nullable = true, length = 500)
    public String getKecontent() {
        return kecontent;
    }

    public void setKecontent(String kecontent) {
        this.kecontent = kecontent;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    @Basic
    @Column(name = "kyword", nullable = true, length = 255)
    public String getKyword() {
        return kyword;
    }

    public void setKyword(String kyword) {
        this.kyword = kyword;
    }

    @Basic
    @Column(name = "titles", nullable = true, length = 1000)
    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    @Basic
    @Column(name = "imageinfo", nullable = true, length = 1000)
    public String getImageinfo() {
        return imageinfo;
    }

    public void setImageinfo(String imageinfo) {
        this.imageinfo = imageinfo;
    }

    @Basic
    @Column(name = "linkinfo", nullable = true, length = 1000)
    public String getLinkinfo() {
        return linkinfo;
    }

    public void setLinkinfo(String linkinfo) {
        this.linkinfo = linkinfo;
    }

    @Basic
    @Column(name = "ismess", nullable = true)
    public Byte getIsmess() {
        return ismess;
    }

    public void setIsmess(Byte ismess) {
        this.ismess = ismess;
    }

    @Basic
    @Column(name = "isfollow", nullable = true)
    public Byte getIsfollow() {
        return isfollow;
    }

    public void setIsfollow(Byte isfollow) {
        this.isfollow = isfollow;
    }

    @Basic
    @Column(name = "iskey", nullable = true)
    public Byte getIskey() {
        return iskey;
    }

    public void setIskey(Byte iskey) {
        this.iskey = iskey;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "token", nullable = false, length = 50)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmKeywordEntity that = (EcmKeywordEntity) o;

        if (kid != that.kid) return false;
        if (type != that.type) return false;
        if (userId != that.userId) return false;
        if (kename != null ? !kename.equals(that.kename) : that.kename != null) return false;
        if (kecontent != null ? !kecontent.equals(that.kecontent) : that.kecontent != null) return false;
        if (kyword != null ? !kyword.equals(that.kyword) : that.kyword != null) return false;
        if (titles != null ? !titles.equals(that.titles) : that.titles != null) return false;
        if (imageinfo != null ? !imageinfo.equals(that.imageinfo) : that.imageinfo != null) return false;
        if (linkinfo != null ? !linkinfo.equals(that.linkinfo) : that.linkinfo != null) return false;
        if (ismess != null ? !ismess.equals(that.ismess) : that.ismess != null) return false;
        if (isfollow != null ? !isfollow.equals(that.isfollow) : that.isfollow != null) return false;
        if (iskey != null ? !iskey.equals(that.iskey) : that.iskey != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kid;
        result = 31 * result + (kename != null ? kename.hashCode() : 0);
        result = 31 * result + (kecontent != null ? kecontent.hashCode() : 0);
        result = 31 * result + (int) type;
        result = 31 * result + (kyword != null ? kyword.hashCode() : 0);
        result = 31 * result + (titles != null ? titles.hashCode() : 0);
        result = 31 * result + (imageinfo != null ? imageinfo.hashCode() : 0);
        result = 31 * result + (linkinfo != null ? linkinfo.hashCode() : 0);
        result = 31 * result + (ismess != null ? ismess.hashCode() : 0);
        result = 31 * result + (isfollow != null ? isfollow.hashCode() : 0);
        result = 31 * result + (iskey != null ? iskey.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }
}
