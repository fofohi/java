package com.demo.test.demo;

import org.springframework.context.ApplicationEvent;

public class BeanC extends ApplicationEvent {


    public BeanC(Object source) {
        super(source);
    }

}
