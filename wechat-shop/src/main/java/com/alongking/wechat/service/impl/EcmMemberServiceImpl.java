package com.alongking.wechat.service.impl;

import com.alongking.wechat.dao.IEcmMemberDao;
import com.alongking.wechat.entity.EcmMemberEntity;
import com.alongking.wechat.service.IEcMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Service("iEcMemberService")
public class EcmMemberServiceImpl implements IEcMemberService {

    @Autowired
    private IEcmMemberDao iEcmMemberDao;

    @Transactional
    public EcmMemberEntity selectUserById(int id) {
        return iEcmMemberDao.selectUserById(id);
    }
}
