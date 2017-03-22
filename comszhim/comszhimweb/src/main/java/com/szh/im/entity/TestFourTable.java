package com.szh.im.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/3/14.
 */
@Entity
@Table(name = "test_four_table")
public class TestFourTable {
    private int id;
    private int fourName;
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
    @Column(name = "four_name")
    public int getFourName() {
        return fourName;
    }

    public void setFourName(int fourName) {
        this.fourName = fourName;
    }

}
