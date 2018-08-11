package com.szh.im.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "get_p2p_user")
public class GetP2pUser {
    private int id;
    private BigDecimal investTotal;
    private String name;

    @Column(name = "id")
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "invest_total")
    public BigDecimal getInvestTotal() {
        return investTotal;
    }

    public void setInvestTotal(BigDecimal investTotal) {
        this.investTotal = investTotal;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
