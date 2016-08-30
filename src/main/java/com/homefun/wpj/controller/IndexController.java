package com.homefun.wpj.controller;

import com.homefun.wpj.service.WxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Name：IndexController
 * Time：2016/8/23 9:47
 * author：WPJ587
 * description：首页控制器
 *
 *
 **/
@Controller
@RequestMapping("/hc")
public class IndexController extends BaseController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    WxService wxService;

    @RequestMapping(value = {"", "/index"}, method = RequestMethod.GET)
    public Object index(HttpServletRequest request, ModelMap map) {
        // 获取code
        String code = request.getParameter("code");
        System.out.println(code);
        Map<String, Object> res = wxService.getWxUserOpenIdAndAccessToken(code);
        if (res != null) {
            // 获取到后进行存储到前台
            map.put("openid", res.get("openid"));
            logger.debug("openid:{}",res.get("openid"));
        }
        // 换取token
        return super.returnPage("index");
    }

    @RequestMapping("/appointment")
    public Object appointment() {
        return super.returnPage("yuyue/appointment");
    }
}
