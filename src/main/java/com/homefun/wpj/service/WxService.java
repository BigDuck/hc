package com.homefun.wpj.service;

import java.util.Map;

/**
 * @Author：wupj
 * @Email：wpjlovehome@gmail.com
 * @Date: 2016/8/26
 * @Version:v 1.0.0
 * @History: 微信相关信息的获取
 *
 **/

public interface WxService {
    /**
     * 获取用户的openId
     * @param code
     * @return
     */
    Map<String,Object> getWxUserOpenIdAndAccessToken(String code);
}
