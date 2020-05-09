package com.aurora.web;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
/**
 * 项目启动类
 * @author  PHQ
 * @create 2020-04-28 22:32
 **/
@SpringBootApplication(scanBasePackages = {"com.aurora.*"})
@ServletComponentScan
@MapperScan("com.aurora.*.mapper")
public class SpringbootWebStart {
    private static final Logger logger = LoggerFactory.getLogger(SpringbootWebStart.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebStart.class, args);
        logger.info("#############启动完成#############");
    }
}
