package com.homefun.wpj.serviceImpl;

import com.homefun.wpj.damain.SUser;
import com.homefun.wpj.damain.SecurityUser;
import com.homefun.wpj.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired  //数据库服务类
    private SUserService suserService;//code7
    @Autowired
    private HttpServletRequest request;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //SUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        //本例使用SUser中的email作为用户名:
        // Bad credentials 这个错误返回后期再说吧
        SecurityUser securityUser;
        try {
            SUser sUser=suserService.loginAndAuth(new SUser(userName));
            securityUser= new SecurityUser(sUser);
            System.out.println(request.getAttribute("captcha"));
        }catch (Exception e) {
            throw new UsernameNotFoundException("user select fail");
        }
        if (securityUser == null) {
            throw new UsernameNotFoundException("UserName " + userName + " not found");
        }
        // SecurityUser实现UserDetails并将SUser的Email映射为username
        return new SecurityUser(securityUser); //code9
    }
}
