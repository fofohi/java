package com.szh.im.common;

import org.hibernate.EmptyInterceptor;
import org.springframework.stereotype.Component;

/**
 * Created by alongsea2 on 2017/4/15.
 */
@Component
public class SqlInterceptor extends EmptyInterceptor{

    @Override
    public String onPrepareStatement(String sql) {

        return super.onPrepareStatement(sql);
    }
}
