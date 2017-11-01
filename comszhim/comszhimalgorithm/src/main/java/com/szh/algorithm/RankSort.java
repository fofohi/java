package com.szh.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by alongsea2 on 2017/10/31.
 */
public class RankSort implements BaseAlgorithm{

    private List<RankDto> rankDtoList = new ArrayList<>();

    public RankSort(){
        RankDto rankDto;
        for(int i = 0 ; i < 20; i++){
            rankDto =  new RankDto();
            if( (i % 2) == 0){
                rankDto.setScore(10);
            }else{
                rankDto.setScore(i * 5 + i);
            }
            rankDto.setUserId(i);
            rankDtoList.add(rankDto);
        }
        rankDtoList.sort((o1, o2) -> o2.getScore() - o1.getScore());
    }



    @Override
    public void runAlgorithm() {
        int rank = 5;
        int length = rankDtoList.size();
        List<RankDto> dataList = new ArrayList<>();
            //for(int i = 0 ; i < length ; i++){
                for(int j = 0 ; j < length ; j++) {
                    if(j + 1 >= length)break;

                    if (rankDtoList.get(j).getScore() == rankDtoList.get(j + 1).getScore()) {
                        dataList.add(rankDtoList.get(j));
                        dataList.add(rankDtoList.get(j + 1));
                        j++;
                        while (j < length){
                            if(rankDtoList.get(j).getScore() == rankDtoList.get(j + 1).getScore()){
                                dataList.add(rankDtoList.get(j + 1));
                                j++;
                            }else {
                                dataList.add(rankDtoList.get(j + 1));
                                break;
                            }
                        }
                    } else {
                        dataList.add(rankDtoList.get(j));
                        rank--;
                    }
                    if(rank <= 0){
                        break;
                    }
                }
            //}
        System.out.println(rankDtoList);
        System.out.println(dataList);
    }


    public static void main(String[] args) {
        new StaticProxy(new RankSort()).getResult();
    }

    private static class RankDto{
        private int userId;
        private int score;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
