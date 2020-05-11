package com.aurora.config.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aurora.common.model.Global;
import com.aurora.common.util.IpUtils;
import com.aurora.common.util.JwtUtil;
import com.aurora.config.annotation.PassJwtToken;
import com.aurora.config.annotation.SystemLog;
import com.aurora.model.auth.User;
import com.aurora.model.system.SysLog;
import com.aurora.service.api.auth.AuthService;
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
    @Autowired
    private AuthService authService;

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
        this.saveSystemLog(joinPoint,"",false);
    }

    /**
     * 异常通知
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(pointcut = "logPointCut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex) {
        if (ex instanceof Exception) {
            logger.error("异常信息："+ex);
            String logDesc =ex.getMessage().substring(0,ex.getMessage().length()>900?900:ex.getMessage().length());
            this.saveSystemLog(joinPoint,logDesc,true);
        }
    }

    /**
     * 保存行为日志
     * @param joinPoint
     * @param logDesc
     * @param isError
     */
    private void  saveSystemLog(JoinPoint joinPoint,String logDesc,boolean isError){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog log = new  SysLog();
        SystemLog systemLog  =  method.getAnnotation(SystemLog.class);
        if (systemLog != null) {
            HttpServletRequest  request =   this.getRequest();
            logger.info("日志记录操作方法:"+systemLog.methods());
            //登录相关接口不携带token
            PassJwtToken passJwtToken  =  method.getAnnotation(PassJwtToken.class);
            if(passJwtToken != null) {
                //获取切点参数
                Object[] args = joinPoint.getArgs();
                if(args.length>0){
                    User userLogin = JSONObject.parseObject(JSON.toJSONString(args[0]), User.class);
                    //假如存在登录用户
                    if (StringUtils.isNotBlank(userLogin.getUsername())) {
                        User user = authService.getUserInfo(userLogin);
                        log.setLogUser(userLogin.getUsername());
                        if(user != null && user.getRole()!=null){
                            log.setLogRole(user.getRole().getName());
                        }else{
                            log.setLogRole("普通角色");
                        }

                    }
                }else{
                    log.setLogUser("test");
                    log.setLogRole("普通角色");
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
            if(isError){
                log.setLogDesc(logDesc);
            }else{
                log.setLogDesc(systemLog.desc());
            }
            log.setLogMothod(systemLog.methods());
            log.setLogCreateTime(new Timestamp(System.currentTimeMillis()));

            if(isError){
                log.setLogType(2);
            }else{
                log.setLogType(1);
            }
            sysLogService.saveLog(log);
        }
    }

    /**
     * 获取request对象
     * @return
     */
    private HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request;
    }

}
