package com.homefun.wpj.serviceImpl;

import com.homefun.wpj.damain.Userinfo;
import com.homefun.wpj.dao.UserinfoMapper;
import com.homefun.wpj.exception.CheckException;
import com.homefun.wpj.service.BaseService;
import com.homefun.wpj.service.UserinfoService;
import com.homefun.wpj.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Name：UserinfoServiceImpl
 * Time：2016/8/29 14:28
 * author：WPJ587
 * description：用户登录
 **/
@Service
public class UserinfoServiceImpl extends BaseService<Userinfo> implements UserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    /**
     * @param userName
     * @param pwd
     * @return
     */
    @Override
    public boolean loginCheck(String userName, String pwd) {
        if (userName == null || pwd == null) {
            throw new CheckException("403","用户名或者密码错误");
        }
        Userinfo userinfo = userinfoMapper.selecyByUserName(userName);
        if(userinfo==null){
            throw  new CheckException("403","用户不存在");
        }
        if (!MD5Utils.encode(userName).equals(userinfo.getUserPwd())) {
            throw  new CheckException("404","用户名或者密码错误");
        }
        return true;
    }
}
