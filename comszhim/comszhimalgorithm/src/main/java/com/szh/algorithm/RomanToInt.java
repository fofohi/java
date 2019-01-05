package com.szh.algorithm;

import java.util.HashMap;

public class RomanToInt {
    private static HashMap<String, Integer> x;

    static {
         x = new HashMap<String, Integer>(){{
            put("I",1);
            put("V",5);
            put("X",10);
            put("L",50);
            put("C",100);
            put("D",500);
            put("M",1000);
        }};
    }

    public static Integer romanToInt(String s){
        char[] y = s.toCharArray();
        int z = 0;
        for (int i = 0; i < y.length ; i++) {
            int l = i + 1;
            Integer prev = RomanToInt.x.get(String.valueOf(y[l - 1]));
            Integer after = l == y.length ? 0 : RomanToInt.x.get(String.valueOf(y[l]));

            if(prev < after){
                z -= prev;
            }else{
                z += prev;
            }
        }
        return z;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
