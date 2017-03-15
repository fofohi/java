package com.szh.im.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/3/14.
 */
@Entity
@Table(name = "test_three_table")
public class TestThreeTable {
    private int id;
    private int threeName;

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
    @Column(name = "three_name")
    public int getThreeName() {
        return threeName;
    }

    public void setThreeName(int threeName) {
        this.threeName = threeName;
    }
}
