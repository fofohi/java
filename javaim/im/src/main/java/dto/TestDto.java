package dto;

import pool.ThreadPool;
import util.CallBackResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dell on 2016/4/25.
 */
public class TestDto implements CallBackResult{

    @Override
    public void run() {
        System.out.println("======testdto "+Thread.currentThread().getName()+"======");
        for (int i = 0; i < 5; i++) {
            System.out.println("111");
        }

    }


    @Override
    public void callback(ThreadPool threadPool) {

    }

    public static void main(String[] args) {
        Integer[] s = new Integer[]{
            9,3,7,4,0,100,1200,330,330,420,7600,99,1000,1,15
        };

       /* List<Integer> ss = new ArrayList<Integer>(){{
            add(9);
            add(2);
            add(3);
            add(7);
            add(4);
            add(0);
            add(100);
            add(1200);
            add(330);
            add(330);
            add(420);
            add(7600);
            add(1000);
            add(15);
            add(1);
        }};*/

        for (int i = 0 ; i < s.length ; i++){
            for(int j = i + 1 ; j < s.length; j++){
                if( s[i] < s[j] ){
                    int tmp = s[j];
                    s[j] = s[i];
                    s[i] = tmp;
                 }
            }
        }

        /*for (int i = 0 ; i < s.length; i++){
            for(int j = 0 ; j < s.length - i - 1; j++){
                if( s[j] < s[j + 1] ){
                    int tmp = s[j];
                    s[j] = s[j+1];
                    s[j+1] = tmp;
                }
            }
        }*/

        /*for (int i = 0 ; i < s.length - 1 ; i++){
            int tmpMinIndex = i;
            int tmpMin = s[i];
            for(int j = i + 1 ; j < s.length; j++){
                if( s[tmpMinIndex] > s[j] ){
                    tmpMinIndex = j;
                }
            }
            s[i] = s[tmpMinIndex];
            s[tmpMinIndex] = tmpMin;
        }*/

        /*for(int i = 1 ; i < s.length; i++){
            for (int j = i - 1 ; j >= 0 ; j--){
                if( s[j] > s[j+1] ){
                    int tmp = s[j];
                    s[j] = s[j+1];
                    s[j+1] = tmp;
                }
            }
        }*/
        //int l = ss.size() - 1;
        /*int l = s.length - 1;
        int b = 0;
        int target = 8888;
        //int tmp = ss.get(b);
        int tmp = s[b];
        s[b] = target;
        s = Arrays.copyOf(s, l + 2);
        while ( b < l ){
            int tmp2 = s[b+1];
            s[b+1] = tmp;
            tmp = tmp2;
            b++;
        }
        s[l+1] = tmp;*/
        /*while ( b < l ){
            int tmp2 = ss.get(b+1);
            ss.set(b + 1,tmp);
            tmp = tmp2;
            b++;
        }
        ss.add(tmp);*/

       /* for (Integer integer : s) {
            System.out.println(integer);
        }*/

    }
}
