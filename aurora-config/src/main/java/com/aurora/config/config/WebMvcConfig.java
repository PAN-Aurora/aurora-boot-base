package com.aurora.config.config;

import com.aurora.config.interceptor.JwtTokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web mvc
 * @author PHQ
 * @create 2020-05-05 20:36
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        JwtTokenInterceptor jwtTokenInterceptor = new JwtTokenInterceptor();
        registry.addInterceptor(jwtTokenInterceptor);
    }
}
