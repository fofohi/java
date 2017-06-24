package com.szh.im.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by alongsea2 on 2017/4/11.
 */

public class MultiDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println(DataSourceAop.t);
        return DataSourceAop.t;
    }
}
