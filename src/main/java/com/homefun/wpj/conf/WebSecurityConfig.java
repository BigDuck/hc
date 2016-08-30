package com.homefun.wpj.conf;

import com.homefun.wpj.serviceImpl.CustomUserDetailsService;
import com.homefun.wpj.serviceImpl.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;//code1

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource; //code2


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //允许所有用户访问”/”和”/home”
        http.authorizeRequests()
                .antMatchers("/admin/login",
                        "/css/**",
                        "/js/**",
                        "/plugin/**",
                        "/img/**",
                        "/font/**",
                        "/hc/**/**").permitAll()
                //其他地址的访问均需验证权限
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //指定登录页是”/login”
                .loginPage("/admin/login")
                .permitAll()
                //登录成功后可使用loginSuccessHandler()存储用户信息，可选。
                .successHandler(loginSuccessHandler())//code3
                .and()
                .logout()
//退出登录后的默认网址是”/home”
                .logoutSuccessUrl("/hc")
                .permitAll()
                .invalidateHttpSession(true)
                .and()
                //登录后记住用户，下次自动登录
                //数据库中必须存在名为persistent_logins的表
                //建表语句见code15
                .rememberMe()
                .tokenValiditySeconds(1209600)
                //指定记住登录信息所使用的数据源
                .tokenRepository(tokenRepository());//code4

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//指定密码加密所使用的加密器为passwordEncoder()
//需要将密码加密后写入数据库 //code13
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());//code5
//不删除凭据，以便记住用户
        auth.eraseCredentials(false);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    public JdbcTokenRepositoryImpl tokenRepository() {
        JdbcTokenRepositoryImpl j = new JdbcTokenRepositoryImpl();
        j.setDataSource(dataSource);
        return j;
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();//code6
    }
}
