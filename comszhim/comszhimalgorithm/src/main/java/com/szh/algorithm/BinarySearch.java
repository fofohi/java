package com.szh.algorithm;

import com.szh.algorithm.pojo.UserPojo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by alongsea2 on 2017/4/18.
 */
public class BinarySearch implements BaseAlgorithm {

    static int findTime = 0;
    @Override
    public void runAlgorithm() {

        List<UserPojo> list = new ArrayList<>();

        UserPojo userPojo;

        for(int i = 0 ; i < 310; i++){
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

        long b = System.currentTimeMillis();
        System.out.println(binary(list, 0, list.size(), 57));
        System.out.println("====>" + (System.currentTimeMillis() - b));
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

    private int binaryInteger(List<Integer> list,int targetId){
        int index = -1;
        int begin = 0;
        int end = list.size() - 1;
        while (begin <= end){
            int middle = (begin + end) / 2 ;
            int find = list.get(middle);
            if(find == targetId){
                index = middle;
                break;
            }else if(find > targetId) {
                middle--;
                end = middle;
            }else{
                middle++;
                begin = middle;
            }
        }
        return index;
    }

    public static void main(String[] args) {
       /* BaseAlgorithm baseAlgorithm = new BinarySearch();
        StaticProxy staticProxy = new StaticProxy(baseAlgorithm);
        staticProxy.getResult();*/
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i * 2 + 1);
        }
        long b = System.currentTimeMillis();
        System.out.println(new BinarySearch().binaryInteger(list,0));
        System.out.println("cost" + (System.currentTimeMillis() - b));

    }
}
