package com.aurora.config.aspect;

import com.aurora.config.annotation.SystemLog;
import com.aurora.model.system.SysLog;
import com.aurora.service.api.system.SysLogApi;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 日志AOP记录
 * @author PHQ
 * @create 2020-05-01 22:54
 **/
@Slf4j
@Configuration
@Aspect
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private SysLogApi sysLogApi;

    //定义切点 针对类上注解含有SystemLog
    @Pointcut(value = "@annotation(com.aurora.config.annotation.SystemLog)")
    public void logPointCut(){}

    /**
     * 后置通知
     * @param joinPoint
     * @param ret
     */
    @AfterReturning(returning = "ret",pointcut = "logPointCut()")
    public void saveSysLog(JoinPoint joinPoint, Object ret){
        logger.info("日志记录开始.........");
        MethodSignature signature = (MethodSignature)  joinPoint.getSignature();
        Method method = signature.getMethod();
        SystemLog systemLog  =  method.getAnnotation(SystemLog.class);
        if (systemLog != null) {
            //注解上的描述
            logger.info("日志记录操作方法:"+systemLog.methods());

            SysLog log = new  SysLog();
            log.setLogIp("127.0.0.1");
            log.setLogUser("admin");
            log.setLogRole("系统管理员");
            //log注解数据
            log.setLogModule(systemLog.module());
            log.setLogUrl(systemLog.url());
            log.setLogDesc(systemLog.desc());
            log.setLogMothod(systemLog.methods());
            log.setLogCreateTime(new Timestamp(System.currentTimeMillis()));
            log.setLogType(1);
            sysLogApi.saveLog(log);
        }

    }

    /**
     * 异常通知
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(pointcut = "logPointCut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex) {
        if (ex instanceof Exception) {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();

            SystemLog systemLog  =  method.getAnnotation(SystemLog.class);
            if (systemLog != null) {
                //注解上的描述
                logger.info("日志记录操作方法:"+systemLog.methods());
                logger.warn(ex.getMessage());

                SysLog log = new  SysLog();
                log.setLogIp("127.0.0.1");
                log.setLogUser("admin");
                log.setLogRole("系统管理员");
                //log注解数据
                log.setLogModule(systemLog.module());
                log.setLogUrl(systemLog.url());
                log.setLogDesc(ex.getMessage());
                log.setLogMothod(systemLog.methods());
                log.setLogCreateTime(new Timestamp(System.currentTimeMillis()));
                log.setLogType(1);
                sysLogApi.saveLog(log);
            }

        }
    }



}
