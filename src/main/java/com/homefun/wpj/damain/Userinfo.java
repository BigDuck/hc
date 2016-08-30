package com.homefun.wpj.damain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Userinfo extends BaseDamain{
    private static final long serialVersionUID = 4052441912826824347L;
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(generator = "UUID")
    private String userId;
    /**
     * 用户名
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 最后登录时间
     */
    @Column(name = "USER_LOGIN")
    private Date userLogin;
    /**
     * 密码
     */
    @Column(name = "USER_PWD")
    private String userPwd;
    /**
     * 最后登录ip
     */
    @Column(name = "USER_LASTIP")
    private String userLastip;

    /**
     * @return USER_ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return USER_NAME
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取最后登录时间
     *
     * @return USER_LOGIN - 最后登录时间
     */
    public Date getUserLogin() {
        return userLogin;
    }

    /**
     * 设置最后登录时间
     *
     * @param userLogin 最后登录时间
     */
    public void setUserLogin(Date userLogin) {
        this.userLogin = userLogin;
    }

    /**
     * @return USER_PWD
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * @param userPwd
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * @return USER_LASTIP
     */
    public String getUserLastip() {
        return userLastip;
    }

    /**
     * @param userLastip
     */
    public void setUserLastip(String userLastip) {
        this.userLastip = userLastip;
    }
}