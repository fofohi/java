package com.szh.algorithm;

import com.szh.algorithm.pojo.UserPojo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by alongsea2 on 2017/4/18.
 */
public class BinarySearch implements BaseAlgorithm {


    @Override
    public void runAlgorithm() {

        List<UserPojo> list = new ArrayList<>();

        UserPojo userPojo;

        for(int i = 0 ; i < 30; i++){
            userPojo = new UserPojo();
            userPojo.setName(i + "user");
            userPojo.setUserId(i * 2 + 1);
            list.add(userPojo);
        }
        list.sort(new Comparator<UserPojo>() {
            @Override
            public int compare(UserPojo o1, UserPojo o2) {
                return o2.getUserId() - o1.getUserId();
            }
        });

        System.out.println(binary(list, 0, list.size(), 60));


    }

    public static void main(String[] args) {
        BaseAlgorithm baseAlgorithm = new BinarySearch();
        StaticProxy staticProxy = new StaticProxy(baseAlgorithm);
        staticProxy.getResult();
    }

    private int binary(List<UserPojo> list, int begin,int end,int targetId){
        if(end > 1) {
            if (targetId > list.get(0).getUserId() || targetId < list.get(end - 1).getUserId()) return -1;
        }

        int findPosition = (begin + end ) / 2;
        UserPojo find = list.get(findPosition);
        if(find == null)return -1;
        if (find.getUserId() == targetId)return findPosition;
        if(find.getUserId() > targetId){
            return binary(list,findPosition + 1,end,targetId);
        }else {
            return binary(list,0,findPosition - 1,targetId);
        }
    }


}
