package com.aurora.config.interceptor;

import com.aurora.common.model.Global;
import com.aurora.common.model.ResultCode;
import com.aurora.common.model.ResultModel;
import com.aurora.common.util.JwtUtil;
import com.aurora.config.annotation.PassJwtToken;
import com.aurora.service.api.auth.AuthService;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 *  token 拦截器
 *    处理token存在和不存在的权限校验
 * @author PHQ
 * @create 2020-05-05 20:40
 **/
public class JwtTokenInterceptor extends HandlerInterceptorAdapter {

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenInterceptor.class);

    //@Value("${jwt.header}")
    private String token_header = Global.JWT_HEADER;

    private String jwt_tokenHead = Global.JWT_TOKENHEAD;

    //@Autowired
    private final static JwtUtil jwtUtil = new JwtUtil() ;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //获取注解是否过滤不校5token
        HandlerMethod method = (HandlerMethod) handler;
        PassJwtToken auth = method.getMethod().getAnnotation(PassJwtToken.class);
        //假如存在PassJwtToken注解就不进行token校验
        if (auth !=null && auth.required()) {
             return super.preHandle(request, response, handler);
        }

        if(StringUtils.isNotBlank(this.token_header)){
            //token header
            String auth_token = request.getHeader(this.token_header);
            final String auth_token_start = this.jwt_tokenHead;
            if (StringUtils.isNotBlank(auth_token) && auth_token.startsWith(auth_token_start)) {
                auth_token = auth_token.substring(auth_token_start.length());
            } else {
                // 不按规范,不允许通过验证
                auth_token = null;
            }
            //假如不存在token
            if(StringUtils.isBlank(auth_token)){

                this.writerResponse(response,ResultCode.NOT_TOKEN_ERROR);
                return false;
            }else{
                 String username = jwtUtil.getUsernameFromToken(auth_token);
                //假如token过期或者找不到
                if(StringUtils.isBlank(username)){
                    this.writerResponse(response,ResultCode.TOKEN_ERROR);
                    return false;
                }else{
                    jwtUtil.refreshToken(auth_token);
                }
            }
        }else{
            return false;
        }
        return super.preHandle(request, response, handler);
    }

    /**
     * 往浏览器输出
     * @param response
     * @param resultCode
     * @throws Exception
     */
    private void  writerResponse( HttpServletResponse response,ResultCode  resultCode) throws Exception{
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        String body = ResultModel.failure(resultCode).toString();
        printWriter.write(body);
        printWriter.flush();
    }
}
