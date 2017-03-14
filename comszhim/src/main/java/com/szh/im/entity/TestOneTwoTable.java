package com.szh.im.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/3/14.
 */
@Entity
@Table(name = "test_one_two_table")
public class TestOneTwoTable {
    private int id;
    private int oneId;
    private int twoId;
    private int extra;

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
    @Column(name = "one_id")
    public int getOneId() {
        return oneId;
    }

    public void setOneId(int oneId) {
        this.oneId = oneId;
    }

    @Basic
    @Column(name = "two_id")
    public int getTwoId() {
        return twoId;
    }

    public void setTwoId(int twoId) {
        this.twoId = twoId;
    }

    @Basic
    @Column(name = "extra")
    public int getExtra() {
        return extra;
    }

    public void setExtra(int extra) {
        this.extra = extra;
    }

}
