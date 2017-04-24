package com.szh.algorithm;

import java.util.*;

/**
 * Created by alongsea2 on 2017/3/28.
 */
public class Application {

    private static class Chance{
        private String name;
        private double percent;

        public Chance(String name, double percent) {
            this.name = name;
            this.percent = percent;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPercent() {
            return percent;
        }

        public void setPercent(double percent) {
            this.percent = percent;
        }
    }


    public static void test(){
        List<Chance> list = new ArrayList<Chance>(){
            {
                add(new Chance("test1",0));
                add(new Chance("test2",0));
                add(new Chance("test3",0));
                add(new Chance("test5",0));
                add(new Chance("test6",0.1));
                add(new Chance("test7",0.99));
            }
        };
        double d = 0;
        for (Chance chance : list) {
            d += chance.getPercent();

        }
        List<Double> list2 = new ArrayList<>();
        for (Chance chance : list){

            double d2 = chance.getPercent() / d;
            list2.add(d2);
        }

        double random = Math.random() * d;
        System.out.println("====>" + random);
        list2.add(random);
        Collections.sort(list2);
        System.out.println(list2.indexOf(random));
    }

    public static void main(String[] args) {

        for(int i = 0 ; i< 10000;i++){
            test();
        }






    }
}
