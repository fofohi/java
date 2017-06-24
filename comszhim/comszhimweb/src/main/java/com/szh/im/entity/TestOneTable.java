package com.szh.im.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/3/14.
 */
@Entity
@Table(name = "test_one_table")
public class TestOneTable {
    private int id;
    private int fourId;
    private String oneName;

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
    @Column(name = "four_id")
    public int getFourId() {
        return fourId;
    }

    public void setFourId(int fourId) {
        this.fourId = fourId;
    }

    @Basic
    @Column(name = "one_name")
    public String getOneName() {
        return oneName;
    }

    public void setOneName(String oneName) {
        this.oneName = oneName;
    }
}
