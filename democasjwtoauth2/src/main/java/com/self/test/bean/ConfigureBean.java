package com.self.test.bean;


import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.IOException;

@Configuration
public class ConfigureBean {

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        resolver.setMaxInMemorySize(40960);
        resolver.setMaxUploadSize(50*1024*1024);//上传文件大小 50M 50*1024*1024
        return resolver;
    }

    /*@Bean
    public FilterRegistrationBean registration(CasFilter filter){
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.addUrlPatterns(matchUrl == null ? "/" : "");
        return registration;
    }
*/
    @Bean
    public FTPClient ftpClient(){

        FTPClient client = new FTPClient();
        try {
            client.connect("192.168.137.105",2121);
            client.login("admin", "123qweasdzxc!@#");
        } catch (IOException e) {
            e.printStackTrace();
            try {
                client.quit();
                System.out.println(client.reinitialize());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return client;
    }

    private void reload(){

    }

}
