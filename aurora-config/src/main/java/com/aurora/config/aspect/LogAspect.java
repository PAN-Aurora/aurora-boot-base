package com.aurora.config.aspect;

import com.aurora.common.model.Global;
import com.aurora.common.util.IpUtils;
import com.aurora.common.util.JwtUtil;
import com.aurora.config.annotation.PassJwtToken;
import com.aurora.config.annotation.SystemLog;
import com.aurora.model.auth.User;
import com.aurora.model.system.SysLog;
import com.aurora.service.api.system.SysLogService;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.jsonwebtoken.Claims;
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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
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
    private SysLogService sysLogService;
    private String token_header = Global.JWT_HEADER;
    private final JwtUtil jwtUtil = new JwtUtil() ;

    private String auth_token = "";

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
        HttpServletRequest  request =   this.getRequest();
        if (systemLog != null) {
            SysLog log = new  SysLog();
            PassJwtToken passJwtToken  =  method.getAnnotation(PassJwtToken.class);
            if(passJwtToken!=null){
                HttpServletResponse  response =  this.getResponse();
                //注解上的描述
                String userName = request.getParameter("username");
                log.setLogUser(userName);
                if(StringUtils.isNotBlank(userName)){
                    User user =  jwtUtil.getUseFromTokenMap(userName);
                    log.setLogRole(user.getRole().getName());
                }



            }else{
                auth_token  = request.getHeader(this.token_header);
                final String auth_token_start =Global.JWT_TOKENHEAD;
                if (StringUtils.isNotBlank(auth_token) && auth_token.startsWith(auth_token_start)) {
                    auth_token = auth_token.substring(auth_token_start.length());
                } else {
                    // 不按规范,不允许通过验证
                    auth_token = null;
                }

                Claims claims = jwtUtil.getClaimsFromToken(auth_token);


                log.setLogUser(claims.get("sub").toString());
                log.setLogRole(claims.get("scope").toString());
            }
            log.setLogIp(IpUtils.getIpAddress(request));
            //log注解数据
            log.setLogModule(systemLog.module());
            log.setLogUrl(systemLog.url());
            log.setLogDesc(systemLog.desc());
            log.setLogMothod(systemLog.methods());
            log.setLogCreateTime(new Timestamp(System.currentTimeMillis()));
            log.setLogType(1);
            sysLogService.saveLog(log);
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
            HttpServletRequest  request =   this.getRequest();
            if (systemLog != null) {
                //注解上的描述
                logger.error("日志记录操作方法:"+systemLog.methods());
                logger.warn("异常信息："+ex);

                SysLog log = new  SysLog();
                log.setLogIp(IpUtils.getIpAddress(request));
                auth_token  = request.getHeader(this.token_header);
                final String auth_token_start =Global.JWT_TOKENHEAD;
                if (StringUtils.isNotBlank(auth_token) && auth_token.startsWith(auth_token_start)) {
                    auth_token = auth_token.substring(auth_token_start.length());
                } else {
                    // 不按规范,不允许通过验证
                    auth_token = null;
                }

                Claims claims = jwtUtil.getClaimsFromToken(auth_token);

                log.setLogIp("127.0.0.1");
                log.setLogUser(claims.get("sub").toString());
                log.setLogRole(claims.get("scope").toString());
                //log注解数据
                log.setLogModule(systemLog.module());
                log.setLogUrl(systemLog.url());
                log.setLogDesc(ex.getMessage().substring(0,ex.getMessage().length()>900?900:ex.getMessage().length()));
                log.setLogMothod(systemLog.methods());
                log.setLogCreateTime(new Timestamp(System.currentTimeMillis()));
                log.setLogType(2);
                sysLogService.saveLog(log);
            }

        }
    }

    public HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request;
    }

    public HttpServletResponse getResponse() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();
        return response;
    }



}
