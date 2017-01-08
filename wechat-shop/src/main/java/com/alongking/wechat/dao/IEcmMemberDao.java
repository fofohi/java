package com.alongking.wechat.dao;

import com.alongking.wechat.entity.EcmMemberEntity;
import org.springframework.stereotype.Component;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Component
public interface IEcmMemberDao {
    EcmMemberEntity selectUserById(int id);
}
