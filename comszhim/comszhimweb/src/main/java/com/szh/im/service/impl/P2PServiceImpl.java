package com.szh.im.service.impl;

import com.szh.im.dao.P2PDao;
import com.szh.im.entity.GetP2p;
import com.szh.im.entity.GetP2pUser;
import com.szh.im.service.P2PService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class P2PServiceImpl implements P2PService {
    
    @Autowired
    private P2PDao p2PDao;
    
    private BigDecimal oneYear = new BigDecimal("365");



    @Transactional
    @Override
    public String getP2P(int userId){
        GetP2pUser user = p2PDao.getP2PUser(userId);
        
        List<GetP2p> userInvest = p2PDao.getP2PInvestPer(userId);

        //计算所有平台相加之后的利率
        BigDecimal totalDayGet = BigDecimal.ZERO;
        for (GetP2p getP2p : userInvest) {
            //每日获得
            BigDecimal dayGet = getP2p.getP2pInvest()
                    .multiply(getP2p.getP2pPer())
                    .divide(oneYear, 2, BigDecimal.ROUND_FLOOR);
            totalDayGet = totalDayGet.add(dayGet);
        }
        BigDecimal truePer = totalDayGet.divide(user.getInvestTotal(),10, BigDecimal.ROUND_FLOOR).multiply(new BigDecimal("100")).multiply(oneYear);
        System.out.println("user id " + userId + "实际利率为:" + truePer + "%" + "\r\n" + "user id " + userId + "每天获利大约为:" + totalDayGet + "元");
        return "user id " + userId + "per is:" + truePer + "%" + "\r\n" + "user id " + userId + "get money is :" + totalDayGet + "元";

    }
}
