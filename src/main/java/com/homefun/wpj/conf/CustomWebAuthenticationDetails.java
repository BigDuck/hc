package com.homefun.wpj.conf;

import com.google.code.kaptcha.Constants;
import com.homefun.wpj.exception.CheckException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
    private Logger logger= LoggerFactory.getLogger(CustomWebAuthenticationDetails.class);
    private static final long serialVersionUID = 6975601077710753878L;
    private final String captcha;

    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        this.captcha = request.getParameter("captcha");
        if(request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY)==null){
            throw new CheckException("403","验证码过期");
        }else {
            if(!request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).equals(captcha)){
                throw new CheckException("403","验证码错误");

            }
        }
        logger.debug("验证码{}",captcha);
    }

    public String getCaptcha() {
        return captcha;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("; Token: ").append(this.getCaptcha());
        return sb.toString();
    }
}