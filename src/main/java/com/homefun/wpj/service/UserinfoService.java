package com.homefun.wpj.service;

import com.homefun.wpj.damain.Userinfo;

/**
 * Name：UserinfoService
 * Time：2016/8/29 14:27
 * author：WPJ587
 * description：
 **/

public interface UserinfoService extends IService<Userinfo> {
    /**
     *
     * @param userName
     * @param pwd
     * @return
     */
    boolean loginCheck(String userName, String pwd);
}
