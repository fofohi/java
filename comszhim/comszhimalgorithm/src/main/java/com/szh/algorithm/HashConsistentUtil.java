package com.jdd.redpacket.commons.util;

/**
 *
 * Created by sunzhuhuan Administrator on 2017/6/19.
 */
public class HashConsistentUtil {


    public static void main(String[] args) {
        /**

         userId : 10 ====>7
         userId : 11 ====>2
         userId : 12 ====>6
         userId : 13 ====>6
         userId : 14 ====>7
         userId : 15 ====>1
         userId : 16 ====>7
         userId : 17 ====>7
         userId : 18 ====>7
         userId : 19 ====>1

         userId : 10 ====>7
         userId : 11 ====>2
         userId : 12 ====>6
         userId : 13 ====>6
         userId : 14 ====>7
         userId : 15 ====>1
         userId : 16 ====>7
         userId : 17 ====>7
         userId : 18 ====>7
         userId : 19 ====>1


         */
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
        };




        for (int i = 10 ;i < 20 ; i++) {
            int bucketIndex = getHash(i + "",tables.length);
            System.out.println("userId : " + i +" ====>" + bucketIndex);
        }


    }

    public static int getHash(String str,int buckets){
        return JumpConsistentHash.jumpConsistentHash(str,buckets);
    }

}
