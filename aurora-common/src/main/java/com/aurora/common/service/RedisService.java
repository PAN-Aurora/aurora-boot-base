package com.aurora.common.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 *  redis 针对RedisTemplate 二次封装的接口
 * @author :PHQ
 * @date：2020/12/29
 **/
@Component
@Service
public interface RedisService {

    public boolean set(final String key, Object value);

    public long  increment(final String key);

    public boolean set(final String key, Object value, Long expireTime, TimeUnit timeUnit);

    public void remove(final String... keys);

    public void removePattern(final String pattern);

}
