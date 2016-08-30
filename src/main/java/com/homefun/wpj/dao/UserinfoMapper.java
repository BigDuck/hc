package com.homefun.wpj.dao;

import com.homefun.wpj.damain.Userinfo;
import com.homefun.wpj.db.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface UserinfoMapper extends MyMapper<Userinfo> {
    Userinfo selecyByUserName(@Param("userName") String userName);
}