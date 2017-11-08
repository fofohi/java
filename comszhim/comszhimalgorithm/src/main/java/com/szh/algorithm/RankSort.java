package com.szh.algorithm;

import java.util.*;

/**
 * Created by alongsea2 on 2017/10/31.
 */
public class RankSort implements BaseAlgorithm {

    private List<RankDto> rankDtoList = new ArrayList<>();

    public RankSort() {
        RankDto rankDto;
        for (int i = 0; i < 100000; i++) {
            rankDto = new RankDto();
            rankDto.setUserId(new Random().nextInt(200));
            rankDto.setScore(new Random().nextInt(200));
            rankDto.setLv(new Random().nextInt(10));
            rankDto.setUsed(new Random().nextInt(200));
            rankDtoList.add(rankDto);
        }
        rankDtoList.sort((o1, o2) -> o2.getScore() - o1.getScore());
    }


    @Override
    public void runAlgorithm() {
        int rank = 12;
        int length = rankDtoList.size();
        int j = 0;
        List<RankDto> dataList = new ArrayList<>();
        while (j < length) {
            if (j + 1 >= length) {
                dataList.add(rankDtoList.get(j));
            }

            if (rankDtoList.get(j) != rankDtoList.get(j + 1)) {
                dataList.add(rankDtoList.get(j));
                rank--;
            } else {
                dataList.add(rankDtoList.get(j));
            }
            j++;
            if (rank == 0) {
                break;
            }
        }
    }


    public static void main(String[] args) {
        new StaticProxy(new RankSort()).getResult();
    }

    private static class RankDto {
        private int userId;
        private int score;
        private int lv;
        private int used;

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

        public int getLv() {
            return lv;
        }

        public void setLv(int lv) {
            this.lv = lv;
        }

        public int getUsed() {
            return used;
        }

        public void setUsed(int used) {
            this.used = used;
        }
    }
}
