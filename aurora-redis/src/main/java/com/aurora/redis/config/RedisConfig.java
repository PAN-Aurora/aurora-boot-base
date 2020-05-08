package com.aurora.redis.config;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.JedisClientConfigurationBuilderCustomizer;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * redis 配置
 * @author PHQ
 * @create 2020-05-08 21:33
 **/
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    @Autowired
    JedisConfig jedisConfig;
    @Autowired
    JedisConnectionFactory jedisConnectionFactory;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory (){
        RedisStandaloneConfiguration redis=new RedisStandaloneConfiguration();
        redis.setDatabase(jedisConfig.database);
        redis.setHostName(jedisConfig.host);
        redis.setPort(jedisConfig.port);
        //int to=Integer.parseInt(jedisConfig.timeout.substring(0,jedisConfig.timeout.length()-2));
        //JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
        //jedisClientConfiguration.connectTimeout(Duration.ofMillis(to));
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder client=
                (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder)JedisClientConfiguration.builder();
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(jedisConfig.maxIdle);
        jedisPoolConfig.setMinIdle(jedisConfig.minIdle);
        jedisPoolConfig.setMaxTotal(jedisConfig.maxActive);
       // int l=Integer.parseInt(jedisConfig.maxWait.substring(0,jedisConfig.maxWait.length()-2));
        jedisPoolConfig.setMaxWaitMillis(Integer.parseInt(jedisConfig.maxWait));
        client.poolConfig(jedisPoolConfig);
        JedisConnectionFactory jedisConnectionFactory=new JedisConnectionFactory(redis,client.build());
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate redisTemplate(){
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        RedisTemplate rt=new RedisTemplate();
        rt.setConnectionFactory(jedisConnectionFactory);
        System.out.println(jedisConnectionFactory.getPoolConfig().getMaxIdle());
        System.out.println(jedisConnectionFactory.getPoolConfig().getMinIdle());
        System.out.println(jedisConnectionFactory.getPoolConfig().getMaxTotal());
        RedisSerializer rs=new StringRedisSerializer();
        rt.setKeySerializer(rs);
        rt.setValueSerializer(jackson2JsonRedisSerializer);
        rt.setHashKeySerializer(rs);
        rt.setHashValueSerializer(jackson2JsonRedisSerializer);
        rt.afterPropertiesSet();
        return rt;

    }
}