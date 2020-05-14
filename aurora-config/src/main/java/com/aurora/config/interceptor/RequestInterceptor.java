package com.aurora.config.interceptor;

import com.aurora.common.model.Global;
import com.aurora.common.model.ResponseModel;
import com.aurora.common.model.ResultCode;
import com.aurora.common.util.IpUtils;
import com.aurora.config.annotation.GuavaRateLimiter;
import com.aurora.redis.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 *  针对所有的请求 进行限制
 *     默认 1分钟之内 一个地址不能请求 n 次
 *     针对没有进行强制限流的方法 使用默认
 */
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {
    private final static Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);
    private RedisUtils redisUtils;

    public RequestInterceptor(RedisUtils redisUtils) {
        this.redisUtils =redisUtils;

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod method = (HandlerMethod) handler;
        GuavaRateLimiter  rateLimiter =   method.getMethod().getAnnotation(GuavaRateLimiter.class);
        //除限流之外的其他接口进行 请求地址限制请求
        if(rateLimiter == null){
            //假如请求受限返回自定义消息
            if(isLimit(request)){
                 ResponseModel.responseResult(response, ResultCode.LIMITER_REDIS_ERROR);
                 return false;
            }else{
                return true;
            }
        }

        return super.preHandle(request, response, handler);
    }

    //判断请求是否受限
    public boolean isLimit(HttpServletRequest request){
        String limitKey =  IpUtils.getIpAddress(request);
        // 从缓存中获取，当前这个请求访问了几次


        if(!redisUtils.exists(limitKey)){
            //初始 次数
            redisUtils.set(limitKey,1, Global.REDIS_LIMITER_SECONDE, TimeUnit.MILLISECONDS);
        }else{
            Integer  redisCount = (Integer)redisUtils.get(limitKey);
            if(redisCount.intValue() >= Global.REDIS_LIMITER_MAXCOUNT){
                return true;
            }
            logger.info("请求ip："+limitKey+",已经请求次数"+redisCount);
            // 次数自增
            redisUtils.increment(limitKey);
        }
        return false;
    }
}
