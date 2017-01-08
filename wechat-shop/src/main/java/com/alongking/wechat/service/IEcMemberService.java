package com.alongking.wechat.service;

import com.alongking.wechat.entity.EcmMemberEntity;
import org.springframework.stereotype.Service;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Service
public interface IEcMemberService {
    EcmMemberEntity selectUserById(int id);
}
