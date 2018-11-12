package com.self.test.bean;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureBean {

    @Value("${match.url}")
    private String matchUrl;


    @Bean
    public FilterRegistrationBean registration(CasFilter filter){
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.addUrlPatterns(matchUrl);
        return registration;
    }
}
