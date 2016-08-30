/*
 * ©2016 wupjhy.cn.  All rights reserved.
 */

package com.homefun.wpj.db;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * Created by WPJ587 on 2015/10/4.
 */
@Configuration
public class OtherConfig {
    /**
     * 这个是为了使用通用mapper而独立配置的tk.mybatis.spring.mapper.MapperScannerConfigurer
     * 不能写在MybatisConfig否则胡出现druidDataSourceEntity为空的情况
     * 我也不知道为什么。
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.homefun.wpj.dao");
        mapperScannerConfigurer.setMarkerInterface(MyMapper.class);
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }
    @Bean(name = "myKaptcha")
    public DefaultKaptcha getDefaultKaptcha(){
        DefaultKaptcha defaultKaptcha=new DefaultKaptcha();
        Properties properties=new Properties();
        properties.put("kaptcha.border","no");
        properties.put(Constants.KAPTCHA_IMAGE_HEIGHT,100);
        properties.put(Constants.KAPTCHA_SESSION_CONFIG_DATE,60);
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR,"red");
        properties.put(Constants.KAPTCHA_SESSION_KEY,"code");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH,4);
        properties.put(Constants.KAPTCHA_BORDER,"no");
        Config config=new Config(properties);
        defaultKaptcha.setConfig(config);
        System.out.println("完成");
        return defaultKaptcha;
    }
}
