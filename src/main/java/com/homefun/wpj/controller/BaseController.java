package com.homefun.wpj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Name：BaseController
 * Time：2016/8/23 9:50
 * author：WPJ587
 * description：基础控制器
 **/
@Controller
public class BaseController {
   protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    HttpServletRequest request;

    public Object returnPage(String url) {
        String Agent = request.getHeader("User-Agent");
        logger.info("IP:"+request.getRemoteAddr()+"Agent"+Agent);
        return url;

    }
}