package com.homefun.wpj.damain;

import javax.persistence.*;

public class Cards extends BaseDamain {
    private static final long serialVersionUID = 8694469135828641608L;
    /**
     * 卡号
     */
    @Id
    @Column(name = "CARD_NUM")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cardNum;

    /**
     * 卡密码
     */
    @Column(name = "CARD_PWD")
    private String cardPwd;

    /**
     * 是否被使用0未使用
     */
    @Column(name = "IS_USED")
    private Boolean isUsed;

    /**
     * 使用者id
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 获取卡号
     *
     * @return CARD_NUM - 卡号
     */
    public String getCardNum() {
        return cardNum;
    }

    /**
     * 设置卡号
     *
     * @param cardNum 卡号
     */
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    /**
     * 获取卡密码
     *
     * @return CARD_PWD - 卡密码
     */
    public String getCardPwd() {
        return cardPwd;
    }

    /**
     * 设置卡密码
     *
     * @param cardPwd 卡密码
     */
    public void setCardPwd(String cardPwd) {
        this.cardPwd = cardPwd;
    }

    /**
     * 获取是否被使用0未使用
     *
     * @return IS_USED - 是否被使用0未使用
     */
    public Boolean getIsUsed() {
        return isUsed;
    }

    /**
     * 设置是否被使用0未使用
     *
     * @param isUsed 是否被使用0未使用
     */
    public void setIsUsed(Boolean isUsed) {
        this.isUsed = isUsed;
    }

    /**
     * 获取使用者id
     *
     * @return USER_ID - 使用者id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置使用者id
     *
     * @param userId 使用者id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}