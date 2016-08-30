package com.homefun.wpj.serviceImpl;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.homefun.wpj.service.KaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Name：KaptchaServiceImpl
 * Time：2016/8/23 14:29
 * author：WPJ587
 * description：验证码
 **/
@Service
public class KaptchaServiceImpl implements KaptchaService {
    @Autowired
    HttpSession httpSession;
    @Autowired
    private DefaultKaptcha myKaptcha;

    @Override
    public Object getSimpleJcatcha(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);

        response.setDateHeader("Expires", 0);

        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");

        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");

        // return a jpeg
        response.setContentType("image/jpeg");

        // create the text for the image
        String capText = myKaptcha.createText();

        // store the text in the session
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        System.out.println("******************设置的验证码是: " + capText + "******************");

        // create the image with the text
        BufferedImage bi = myKaptcha.createImage(capText);
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 验证验证码是否正确
     *
     * @param code
     * @return 成功true 失败false
     */
    @Override
    public boolean checkKaptcha(String code) {
        String trueCode = (String) httpSession.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (trueCode!=null){
            if (trueCode.equals(code)){
                return true;
            }
        }
        return false;
    }

}
