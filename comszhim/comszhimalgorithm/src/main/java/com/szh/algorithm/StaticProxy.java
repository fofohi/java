package com.szh.algorithm;

/**
 * Created by alongsea2 on 2017/3/28.
 */
public class StaticProxy {

    private BaseAlgorithm baseAlgorithm;

    public StaticProxy(BaseAlgorithm baseAlgorithm) {
        this.baseAlgorithm = baseAlgorithm;
    }

    public void getResult(){
        long b = System.currentTimeMillis();
        baseAlgorithm.runAlgorithm();
        System.out.println("====> cost time " + (System.currentTimeMillis() - b));
    }

}
