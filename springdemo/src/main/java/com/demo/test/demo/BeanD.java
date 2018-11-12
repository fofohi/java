package com.demo.test.demo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

public class BeanD implements ApplicationEventPublisher {

    public void publishEvent(ApplicationEvent event) {
        System.out.println(event);
    }

    public void publishEvent(Object event) {
        System.out.println(event);
    }
}
