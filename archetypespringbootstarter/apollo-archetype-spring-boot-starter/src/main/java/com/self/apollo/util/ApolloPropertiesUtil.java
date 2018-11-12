package com.self.apollo.util;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.internals.DefaultConfigManager;
import com.self.apollo.exception.ApolloConfigErrorException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

public class ApolloPropertiesUtil extends DefaultConfigManager implements ApplicationContextAware{

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String getProperties(String property){
        String value;
        String nameSpaces = applicationContext.getEnvironment().getProperty("apollo.bootstrap.namespaces");
        if(!StringUtils.isEmpty(nameSpaces)){
            //try each namespace for this properties;
            String[] nameSpaceList = nameSpaces.split(",");
            for (String s : nameSpaceList) {
                Config configNameSpace = ConfigService.getConfig(s);
                value = configNameSpace.getProperty(property,null);
                if(!StringUtils.isEmpty(value)){
                    return value;
                }
            }

        }else{
            throw new ApolloConfigErrorException("in application*.properties, can't find [apollo.bootstrap.namespaces]");
        }
        //final try the application env property
        value = applicationContext.getEnvironment().getProperty(property);
        if(!StringUtils.isEmpty(value)){
            return value;
        }
        return value;
    }


}
