package com.szh.algorithm;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.util.*;

/**
 * Created by alongsea2 on 2017/3/28.
 *
 */
public class Application {



    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Application.class);

        enhancer.setCallback(NoOp.INSTANCE);
        Object ep = enhancer.create();



    }
}
