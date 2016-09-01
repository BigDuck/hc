package com.homefun.wpj;

import com.homefun.wpj.damain.SUser;
import com.homefun.wpj.service.SUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

/**
 * Name：User
 * Time：2016/8/30 16:18
 * author：WPJ587
 * description：
 **/
@Rollback(value = false)

public class User extends BaseTest {
    @Autowired
    SUserService sUserService;

    @Test
    public void insertUser() {
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder(4);
        SUser sUser = new SUser();
        sUser.setEmail("757671834@qq.com");
        sUser.setName("吴培基");
        sUser.setPassword(bc.encode("123456789"));
//        SRole sRole=new SRole();
//        sRole.setName("admin");
//        Set role=new HashSet();
//        role.add(sRole);
//        sUser.setSRoles(role);
        sUserService.save(sUser);

    }
}
