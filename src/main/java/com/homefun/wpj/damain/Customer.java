package com.homefun.wpj.damain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.homefun.wpj.conf.MyDateSerializer;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Customer extends BaseDamain {
    private static final long serialVersionUID = 3403238912813797374L;
    /**
     * 用户id
     */
    @Column(name = "USER_ID")
    @GeneratedValue(generator = "UUID")
    @Id
    private String userId;

    /**
     * 用户微信唯一标识opneid
     */
    @Column(name = "USER_WX")
    private String userWx;

    @Column(name = "USER_PHONE")
    private String userPhone;

    /**
     * 送货地址
     */
    @Column(name = "USER_ADDRESS")
    private String userAddress;

    /**
     * 用户名
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 订单信息
     */
    @Column(name = "USER_ORDER")
    private String userOrder = "0_待审核";

    /**
     * 客户使用的卡券号码
     */
    @Column(name = "CARD_NUM")
    private String cardNum;

    /**
     * 用户备注
     */
    @Column(name = "USER_OTHER")
    private String userOther;

    /**
     * 用户反馈
     */
    @Column(name = "USER_FB")
    private String userFb;
    /**
     * 下单时间
     */
    @Column(name = "ORDER_TIME")
    @JsonSerialize(using = MyDateSerializer.class) // 返回的时间格式
    private Date userTime;

    /**
     * 获取用户id
     *
     * @return USER_ID - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取用户微信唯一标识
     *
     * @return USER_WX - 用户微信唯一标识
     */
    public String getUserWx() {
        return userWx;
    }

    /**
     * 设置用户微信唯一标识
     *
     * @param userWx 用户微信唯一标识
     */
    public void setUserWx(String userWx) {
        this.userWx = userWx;
    }

    /**
     * @return USER_PHONE
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * @param userPhone
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取送货地址
     *
     * @return USER_ADDRESS - 送货地址
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * 设置送货地址
     *
     * @param userAddress 送货地址
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    /**
     * 获取用户名
     *
     * @return USER_NAME - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取订单信息
     *
     * @return USER_ORDER - 订单信息
     */
    public String getUserOrder() {
        return userOrder;
    }

    /**
     * 设置订单信息
     *
     * @param userOrder 订单信息
     */
    public void setUserOrder(String userOrder) {
        this.userOrder = userOrder;
    }

    /**
     * 获取客户使用的卡券号码
     *
     * @return CARD_NUM - 客户使用的卡券号码
     */
    public String getCardNum() {
        return cardNum;
    }

    /**
     * 设置客户使用的卡券号码
     *
     * @param cardNum 客户使用的卡券号码
     */
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    /**
     * 获取用户备注
     *
     * @return USER_OTHER - 用户备注
     */
    public String getUserOther() {
        return userOther;
    }

    /**
     * 设置用户备注
     *
     * @param userOther 用户备注
     */
    public void setUserOther(String userOther) {
        this.userOther = userOther;
    }

    /**
     * 获取用户反馈
     *
     * @return USER_FB - 用户反馈
     */
    public String getUserFb() {
        return userFb;
    }

    /**
     * 设置用户反馈
     *
     * @param userFb 用户反馈
     */
    public void setUserFb(String userFb) {
        this.userFb = userFb;
    }

    public Date getUserTime() {
        return userTime;
    }

    public void setUserTime(Date userTime) {
        this.userTime = userTime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId='" + userId + '\'' +
                ", userWx='" + userWx + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userName='" + userName + '\'' +
                ", userOrder='" + userOrder + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", userOther='" + userOther + '\'' +
                ", userFb='" + userFb + '\'' +
                '}';
    }
}