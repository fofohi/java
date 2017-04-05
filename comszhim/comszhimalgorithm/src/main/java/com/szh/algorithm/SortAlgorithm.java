package com.szh.algorithm;

import java.io.*;
import java.util.Random;

/**
 * Created by alongsea2 on 2017/3/28.
 */
public class SortAlgorithm implements BaseAlgorithm {

    public static void main(String[] args) {
        BaseAlgorithm baseAlgorithm = new SortAlgorithm();
        StaticProxy staticProxy = new StaticProxy(baseAlgorithm);
        staticProxy.getResult();
    }

    @Override
    public void runAlgorithm() {

    }

}
