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

    /**
     * 1.卡信息入 redis
     * hash  hansel:card:info key cardId | value cardInfo json
     * 2.卡用户关系入 redis
     * hash handsel:user:info:status key userId | value sorted list json {handselUserId,cardId} sorted by handselUserId 只存储500条,超过500条的查询使用数据库
     * 3.卡余额 入redis
     * hash hansel:user:remain key userId:handselUserId | value remain
     *
     * ===========================================================================
     *
     * 1.查询
     * 传userId status 找 handsel:user:info:status 里面对应的userId 的list 内存排序
     *
     *
     */
}
