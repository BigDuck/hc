/*
 * Copyright (c) 2015 - 9 - 18   9 : 57 : 58
 * @author J   It will be
 */

package com.homefun.wpj.conf;

/**
 * Created by WPJ587 on 2015/9/18.
 */
public class WXconfig {
    /**
     * 获取code
     *= "https://open.weixin.qq.com/connect/oauth2/authorize?" +
     *"appid=" + appid+
     *"&redirect_uri=" +
     *backUri+
     "&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
     */
    public static final String WX_GET_CODE="https://open.weixin.qq.com/connect/oauth2/authorize?";
    /**
     * 获取授权
     */
    public static final String WX_GETTOKEN="https://api.weixin.qq.com/sns/oauth2/access_token?";
    /**
     * 统一下单
     */
    public static final String WX_ORDER="https://api.mch.weixin.qq.com/pay/unifiedorder";
    /**
     * 微信开发平台应用id
     */
    public static final String WX_APP_ID = "wxbda894bff7b56df5";
    /**
     * 应用对应的凭证
     */
    public static final String WX_APP_SECRET = "361ce19bd4cfc3559cad0bf3fd4b4ed4";
    /**
     * 微信支付密钥
     */
    public static final String WX_APP_KEY="361ce19bd4cfc3559cad0bf3fd4b4ed4";
    /**
     * 商户号
     */
    public static final String WX_MCHID="1268280401";
    /**
     * 支付时候的access_token
     */
    public static final String WX_ACCESS_TOKEN="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+WX_APP_ID+"&secret="+WX_APP_SECRET;
    /**
     * http请求方式: POST
     * https://api.weixin.qq.com/card/create?access_token=ACCESS_TOKEN
     会员卡
     */
    public static final String WX_CARD="https://api.weixin.qq.com/card/create?access_token=";
}
