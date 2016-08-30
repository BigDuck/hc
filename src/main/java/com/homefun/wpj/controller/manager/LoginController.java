package com.homefun.wpj.controller.manager;

import com.homefun.wpj.damain.Userinfo;
import com.homefun.wpj.exception.CheckException;
import com.homefun.wpj.service.UserinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Name：LoginController
 * Time：2016/8/29 13:46
 * author：WPJ587
 * description：登录
 **/
@Controller
@RequestMapping("/admin")
public class LoginController extends BaseManagerController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserinfoService userinfoService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        String Agent = request.getHeader("User-Agent");
        logger.info("IP:" + request.getRemoteAddr() + "Agent" + Agent);
        return "manager/login";
    }

    @RequestMapping(value = "/manager", method = RequestMethod.POST)
    @ResponseBody
    public String check(Userinfo userinfo, HttpSession session,String code) {
        System.out.println("code"+code);
        if(code==null||!session.getAttribute("code").equals(code)){
            throw new CheckException("403","验证码错误");
        }
        boolean result = userinfoService.loginCheck(userinfo.getUserName(), userinfo.getUserPwd());
        if (!result) {
            throw new CheckException("403", "用户名或密码错误");
        }
        session.setAttribute("peopletoken", UUID.randomUUID());

        return "1";
    }
}
