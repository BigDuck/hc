/*
 * Copyright (c) 2016 - 2 - 29  4 : 37 :31
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.homefun.wpj.service;


import com.homefun.wpj.damain.SUser;

import java.util.List;

/**
 *
 */
public interface SUserService extends IService<SUser> {
    SUser login(String email, String password);
    List<SUser> findSUser(SUser sUser);
    /**
     * 登录验证
     * @param sUser
     * @return
     */
    SUser loginAndAuth(SUser sUser);
}
