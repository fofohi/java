package com.szh.im.dao;

import com.szh.im.entity.GetP2p;
import com.szh.im.entity.GetP2pUser;

import java.util.List;

public interface P2PDao {

    List<GetP2p> getP2PInvestPer(int userId);

    GetP2pUser getP2PUser(int userId);

}
