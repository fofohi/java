package com.maple.spider.entity.dto;

import com.maple.spider.entity.CarCategory;

import java.util.List;

/**
 * Created by dell on 2016/10/14.
 */
public class YiSpiderTaskDto {
    private String chars;
    private List<CarCategory> listCategory;

    public String getChars() {
        return chars;
    }

    public void setChars(String chars) {
        this.chars = chars;
    }

    public List<CarCategory> getListCategory() {
        return listCategory;
    }

    public void setListCategory(List<CarCategory> listCategory) {
        this.listCategory = listCategory;
    }
}
