package com.homefun.wpj.dao;

import com.homefun.wpj.damain.SUser;
import com.homefun.wpj.db.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface SUserMapper extends MyMapper<SUser> {
    SUser selectUserBySuser(@Param("sUser") SUser sUser);
}