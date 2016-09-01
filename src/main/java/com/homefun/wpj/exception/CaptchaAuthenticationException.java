package com.homefun.wpj.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Name：CaptchaAuthenticationException
 * Time：2016/9/1 10:44
 * author：WPJ587
 * description：验证码一场
 **/

public class CaptchaAuthenticationException extends AuthenticationException {
    private static final long serialVersionUID = -777111976408395559L;

    /**
     * Constructs an {@code AuthenticationException} with the specified message and no
     * root cause.
     *
     * @param msg the detail message
     */
    public CaptchaAuthenticationException(String msg) {
        super(msg);
    }
}
