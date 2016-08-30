package com.homefun.wpj.controller;

import com.homefun.wpj.service.KaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Name：UtilController
 * Time：2016/8/23 13:58
 * author：WPJ587
 * description：工具类控制器
 **/
@Controller
@RequestMapping("/hc/kaptch")
public class UtilController {
    @Autowired
    KaptchaService kaptchaService;
    @RequestMapping(value = {"","/photo"})
    public Object getKaptcha(HttpServletRequest request, HttpServletResponse response){
        return kaptchaService.getSimpleJcatcha(request,response);
    }
    @RequestMapping(value = "/check")
    @ResponseBody
    public Object checkKaptcha(@RequestParam(name = "code")String code){
        int res=0;
        if(kaptchaService.checkKaptcha(code)){
            res=1;
        }
        return res;
    }
}
