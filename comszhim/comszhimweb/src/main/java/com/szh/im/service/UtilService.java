package com.szh.im.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alongsea2 on 2017/3/11.
 */
@Service
public class UtilService {
    public UtilService() {

    }

    public void getProperty() {

        System.out.println("=====>");

    }

    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>();
//
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//
//        for (int i = 0 ; i < list.size();i++) {
//            System.out.println(list.size());
//            list.remove(i);
//        }
//
//        System.out.println(list);
        int x = 0;
        System.out.println(x++);
        System.out.println(x);
        System.out.println(++x);
    }

    static void quickSort(int[] sort,int begin,int end){
        if(begin == end) return;
        int middle = (begin + end) / 2;
        int middleEle = sort[middle];
    }
}