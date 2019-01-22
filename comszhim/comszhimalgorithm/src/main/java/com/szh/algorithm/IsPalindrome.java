package com.szh.algorithm;

public class IsPalindrome {

    public static boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int compareInt = 0;
        //1231321
        while (x > compareInt){
            int ret = x % 10;
            x /= 10;
            //if(compareInt == x)return true;
            compareInt = compareInt * 10 + ret;
            System.out.println(ret + ":" + x + ":" + compareInt);
        }
        return compareInt / 10 == x || compareInt == x;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome(5431345));
    }
}
