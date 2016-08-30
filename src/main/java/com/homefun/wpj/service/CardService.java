package com.homefun.wpj.service;

import com.homefun.wpj.damain.Cards;

/**
 * Name：CardService
 * Time：2016/8/24 14:09
 * author：WPJ587
 * description：卡券验证
 **/

public interface CardService extends IService<Cards> {
    /**
     * 注销卡
     * * @return
     */
    boolean writtenOffCard(String cardNum);
}
