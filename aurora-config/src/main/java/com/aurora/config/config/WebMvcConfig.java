package com.aurora.config.config;

import com.aurora.config.interceptor.JwtTokenInterceptor;
import com.aurora.config.interceptor.RequestInterceptor;
import com.aurora.redis.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * webmvc 配置
 * @author PHQ
 * @create 2020-05-05 20:36
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 配置自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //针对所有进行token校验拦截
        registry.addInterceptor(new JwtTokenInterceptor()).addPathPatterns("/**");
        //进行api限流拦截
        registry.addInterceptor(new RequestInterceptor(redisUtils)).addPathPatterns("/**");
    }
}
