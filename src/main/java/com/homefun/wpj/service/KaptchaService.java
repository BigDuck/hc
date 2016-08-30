package com.homefun.wpj.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by WPJ587 on 2016/8/23.
 */
public interface KaptchaService {
    Object getSimpleJcatcha(HttpServletRequest request, HttpServletResponse response);

    /**
     * 验证验证码是否正确
     * @param code
     * @return
     */
    boolean checkKaptcha(String code);
}
