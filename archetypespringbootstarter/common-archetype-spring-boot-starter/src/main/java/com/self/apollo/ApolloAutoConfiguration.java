package com.self.apollo;


import com.self.apollo.exception.ApolloConfigErrorException;
import com.self.apollo.util.ApolloPropertiesUtil;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.util.StringUtils;

/**
 * 在spring boot 启动时定义,保证 直接读取 application内的apollo的env值,设置到环境变量
 * @author  @author <a href="mail to: sunzhuhuan@jiangduoduo.com" rel="nofollow">sunzhuhuan</a>
 */
@Configuration
public class ApolloAutoConfiguration implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        String apolloEnvValue = "";
        String apolloAppIdValue = "";
        MutablePropertySources springSources = applicationContext.getEnvironment().getPropertySources();
        for (PropertySource<?> springSource : springSources) {
            String apolloEnv = "apollo.env";
            if (springSource.containsProperty(apolloEnv)) {
                apolloEnvValue = (String) springSource.getProperty(apolloEnv);
                if (!StringUtils.isEmpty(apolloEnvValue)) {
                    System.setProperty("env", apolloEnvValue);
                }
            }
            String apolloAppId = "apollo.app.id";
            if(springSource.containsProperty(apolloAppId)){
                apolloAppIdValue = (String) springSource.getProperty(apolloAppId);
                if (!StringUtils.isEmpty(apolloAppIdValue)) {
                    System.setProperty("app.id", apolloAppIdValue);
                }
            }
        }
        if(StringUtils.isEmpty(apolloEnvValue) || StringUtils.isEmpty(apolloAppIdValue)){
            throw new ApolloConfigErrorException("apollo starter need appId and env value,check for this two config");
        }
    }

    @Bean
    public ApolloPropertiesUtil getApolloPropertiesUtil(){
        return new ApolloPropertiesUtil();
    }
}