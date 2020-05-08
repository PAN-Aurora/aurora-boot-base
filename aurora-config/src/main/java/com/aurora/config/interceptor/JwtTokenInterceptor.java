package com.aurora.config.interceptor;

import com.aurora.common.model.Global;
import com.aurora.common.model.ResultCode;
import com.aurora.common.model.ResultModel;
import com.aurora.common.util.JwtUtil;
import com.aurora.config.annotation.PassJwtToken;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 *  token 拦截器 处理token存在和不存在
 * @author PHQ
 * @create 2020-05-05 20:40
 **/
public class JwtTokenInterceptor extends HandlerInterceptorAdapter {

    //@Value("${jwt.header}")
    private String token_header = Global.JWT_HEADER;

    //@Autowired
    private JwtUtil jwtUtil = new JwtUtil() ;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //获取注解是否过滤不校5token
        HandlerMethod method = (HandlerMethod) handler;
        PassJwtToken auth = method.getMethod().getAnnotation(PassJwtToken.class);
        //假如存在注解就不进行token校验
        if (auth !=null && auth.required()) {
             return super.preHandle(request, response, handler);
        }
        if(StringUtils.isNotBlank(this.token_header)){
            //token header
            String auth_token = request.getHeader(this.token_header);
            final String auth_token_start = "Bearer ";
            if (StringUtils.isNotBlank(auth_token) && auth_token.startsWith(auth_token_start)) {
                auth_token = auth_token.substring(auth_token_start.length());
            } else {
                // 不按规范,不允许通过验证
                auth_token = null;
            }
            //假如不存在token
            if(StringUtils.isBlank(auth_token)){
                response.setStatus(200);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                PrintWriter printWriter = response.getWriter();
                String body = ResultModel.failure(ResultCode.NOT_TOKEN_ERROR).toString();
                printWriter.write(body);
                printWriter.flush();
                return false;
            }else{
                 String username = jwtUtil.getUsernameFromToken(auth_token);
                //假如
                if(StringUtils.isBlank(username) && SecurityContextHolder.getContext().getAuthentication() == null){
                    jwtUtil.deleteToken(username);

                    response.setStatus(200);
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("application/json; charset=utf-8");
                    PrintWriter printWriter = response.getWriter();
                    String body = ResultModel.failure(ResultCode.TOKEN_ERROR).toString();
                    printWriter.write(body);
                    printWriter.flush();
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
}
