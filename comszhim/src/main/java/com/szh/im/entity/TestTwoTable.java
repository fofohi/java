package com.szh.im.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/3/14.
 */
@Entity
@Table(name = "test_two_table", schema = "jap_test", catalog = "")
public class TestTwoTable {
    private int id;
    private int twoName;
    private int oneId;

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
    @Column(name = "two_name")
    public int getTwoName() {
        return twoName;
    }

    public void setTwoName(int twoName) {
        this.twoName = twoName;
    }

    @Basic
    @Column(name = "one_id")
    public int getOneId() {
        return oneId;
    }

    public void setOneId(int oneId) {
        this.oneId = oneId;
    }

}
