package com.szh.im.common;

/**
 *
 * Created by sunzhuhuan Administrator on 2017/6/19.
 */
public class HashConsistentUtil {


    public static void main(String[] args) {
        String[] tables = new String[]{
                "表0",
                "表1",
                "表2",
                "表3",
                "表5",
                "表5",
                "表6",
                "表7",
                "表8",
                "表9",
                "表10",
                "表11",
        };

        /**
         *
         *
         userId : 1 ====>3
         userId : 2 ====>10
         userId : 3 ====>1
         userId : 4 ====>0
         userId : 5 ====>9
         userId : 6 ====>11
         userId : 7 ====>1
         userId : 8 ====>6
         userId : 9 ====>10
         userId : 10 ====>7
         userId : 11 ====>2
         userId : 12 ====>12
         userId : 13 ====>6
         userId : 14 ====>10
         userId : 15 ====>1
         userId : 16 ====>7
         userId : 17 ====>12
         userId : 18 ====>11
         userId : 19 ====>1



         userId : 1 ====>3
         userId : 2 ====>10
         userId : 3 ====>1
         userId : 4 ====>0
         userId : 5 ====>9
         userId : 6 ====>11
         userId : 7 ====>1
         userId : 8 ====>6
         userId : 9 ====>10
         userId : 10 ====>7
         userId : 11 ====>2
         userId : 12 ====>6
         userId : 13 ====>6
         userId : 14 ====>10
         userId : 15 ====>1
         userId : 16 ====>7
         userId : 17 ====>7
         userId : 18 ====>11
         userId : 19 ====>1
         */


        for (int i = 1;i < 20 ; i++) {
            int bucketIndex = getHash(i + "",tables.length);
            System.out.println("userId : " + i +" ====>" + bucketIndex);
        }


    }

    public static int getHash(String str,int buckets){
        return JumpConsistentHash.jumpConsistentHash(str,buckets);
    }

}
