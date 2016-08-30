package com.homefun.wpj.serviceImpl;

import com.homefun.wpj.damain.Cards;
import com.homefun.wpj.dao.CardsMapper;
import com.homefun.wpj.service.BaseService;
import com.homefun.wpj.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Name：CardServiceImpl
 * Time：2016/8/24 14:12
 * author：WPJ587
 * description：卡券
 **/
@Service
public class CardServiceImpl extends BaseService<Cards> implements CardService {
    private Logger logger= LoggerFactory.getLogger(CardServiceImpl.class);
    @Autowired
    CardsMapper cardsMapper;

    /**
     * 注销卡
     * * @return
     *
     * @param cardNum
     */
    @Override
    public boolean writtenOffCard(String cardNum) {
        Cards cards=new Cards();
        cards.setCardNum(cardNum);
        cards.setIsUsed(true);
        try{
            this.updateNotNull(cards);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
