package com.szh.algorithm;


import java.util.*;

/**
 * Created by alongsea2 on 2017/3/28.
 */
public class Application {

    public static int i1=0;
    public static int i2=0;
    public static int i3=0;
    public static int i4=0;
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
                add(new Chance("test2",0.05));
                add(new Chance("test3",0.95));
                add(new Chance("test4",0.15));
            }
        };
        int d = 0;
        for (Chance chance : list) {
            d += chance.getPercent() * 100;
        }
        int r = new Random().nextInt(d);
        int begin = 0;
        int end = 0;

        for(int i = 0; i < list.size() ; i++){
            if(list.get(i).getPercent() == 0)continue;
            end += list.get(i).getPercent() * 100;
            if(r >= begin && r <= end){
                if(list.get(i).getName() .equals("test1")){
                    i1++;
                    break;
                }else if(list.get(i).getName().equals("test2")){
                    i2++;
                    break;
                }else if(list.get(i).getName().equals("test3")){
                    i3++;
                    break;
                }else if(list.get(i).getName().equals("test4")){
                    i4++;
                    break;
                }
            }
            begin += list.get(i).getPercent() * 100;
        }
    }

    public static void main(String[] args) {

        for(int i = 0 ; i< 10000;i++){
            test();
        }






    }
}
