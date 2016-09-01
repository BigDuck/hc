package com.homefun.wpj.conf;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
    /**
     * 
     */
    private static final long serialVersionUID = 6975601077710753878L;
    private final String captcha;

    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        System.out.println(request.getAttribute("captcha"));
        captcha = request.getParameter("captcha");
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