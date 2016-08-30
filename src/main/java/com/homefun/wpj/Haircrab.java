package com.homefun.wpj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration
@EnableWebSecurity

public class Haircrab extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(Haircrab.class, args);
    }
}
