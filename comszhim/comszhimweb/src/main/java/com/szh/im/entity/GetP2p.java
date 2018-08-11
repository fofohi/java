package com.szh.im.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "get_p2p")
public class GetP2p {
    private int id;
    private String p2pName;
    private int p2pUserId;
    private BigDecimal p2pInvest;
    private BigDecimal p2pPer;


    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "p2p_name")
    public String getP2pName() {
        return p2pName;
    }

    public void setP2pName(String p2pName) {
        this.p2pName = p2pName;
    }

    @Column(name = "p2p_user_id")
    public int getP2pUserId() {
        return p2pUserId;
    }

    public void setP2pUserId(int p2pUserId) {
        this.p2pUserId = p2pUserId;
    }

    @Column(name = "p2p_invest")
    public BigDecimal getP2pInvest() {
        return p2pInvest;
    }

    public void setP2pInvest(BigDecimal p2pInvest) {
        this.p2pInvest = p2pInvest;
    }

    @Column(name = "p2p_per")
    public BigDecimal getP2pPer() {
        return p2pPer;
    }

    public void setP2pPer(BigDecimal p2pPer) {
        this.p2pPer = p2pPer;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
