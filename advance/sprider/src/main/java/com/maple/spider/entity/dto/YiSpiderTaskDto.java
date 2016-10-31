package com.maple.spider.entity.dto;

import com.maple.spider.entity.CarCategory;
import com.maple.spider.queue.SpiderQueue;

import java.util.List;

/**
 * Created by dell on 2016/10/14.
 */
public class YiSpiderTaskDto{
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

<<<<<<< HEAD
=======
    @Override
    public void run() {
        System.out.println(SpiderQueue.flag);
        if(this.chars.equals("Z")){
            SpiderQueue.flag = false;
        }
    }
>>>>>>> 0a3e144ff6601b7e05f2d2580a41494a30df40f6
}
