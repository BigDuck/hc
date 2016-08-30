package com.homefun.wpj.controller;

import com.homefun.wpj.damain.Cards;
import com.homefun.wpj.exception.CheckException;
import com.homefun.wpj.service.CardService;
import com.homefun.wpj.service.KaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Name：CardsController
 * Time：2016/8/24 14:17
 * author：WPJ587
 * description：卡券相关
 **/
@Controller
@RequestMapping("/hc")
public class CardsController extends BaseController {
    @Autowired
    CardService cardService;
    @Autowired
    KaptchaService kaptchaService;

    /**
     * 验证卡券正确性
     *
     * @param cardNum
     * @param cardPwd
     * @param code
     * @return
     */
    @RequestMapping(value = "/cards/check", method = RequestMethod.POST)
    @ResponseBody
    public Object checkCards(@RequestParam("cardNum") String cardNum,
                             @RequestParam("cardPwd") String cardPwd,
                             @RequestParam("code") String code, HttpSession session
    ) {
        // 第二次验证验证码的正确性
        if (!kaptchaService.checkKaptcha(code)) {
            throw new CheckException("400", "验证码错误,请勿非法登录");
        }
        Cards dataCard = cardService.selectByKey(cardNum); // 根据卡券编号去查询
        if (dataCard == null) {
            throw new CheckException("400", "该券不存在,如有疑问请联系客服");
        }
        if (!dataCard.getCardPwd().equals(cardPwd)) {
            throw new CheckException("400", "密码错误");
        }
        if (dataCard.getIsUsed()) {
            throw new CheckException("400", "该券已使用");
        }
        Map<String, Object> res = new HashMap<>();// 验证成功后的事情
        String token = UUID.randomUUID().toString();
        res.put("token", token);
        res.put("cardNum", cardNum);
        session.setAttribute("token", token);
        return res;
    }
    @RequestMapping(value = "/cards/msg")
    public Object userMessage(HttpServletRequest request, ModelMap map) {
        HttpSession session=request.getSession();
        String trueToken = "" + session.getAttribute("token");
        System.out.println(trueToken);
        String token = request.getParameter("token");
        if (!trueToken.equals(token)) {
            throw new CheckException("403", "非法提交");
        }
        String newToken=UUID.randomUUID().toString();
        session.setAttribute("newToken",newToken);
        map.put("newToken", newToken);
        String cardNum = request.getParameter("cardNum");
        map.put("cardNum", cardNum);
        return "yuyue/message";
    }
}
