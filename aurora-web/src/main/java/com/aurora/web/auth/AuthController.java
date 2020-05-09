package com.aurora.web.auth;

import com.aurora.common.model.ResultCode;
import com.aurora.common.model.ResultModel;
import com.aurora.config.annotation.PassJwtToken;
import com.aurora.config.annotation.SystemLog;
import com.aurora.model.auth.ResponseUserToken;
import com.aurora.model.auth.User;
import com.aurora.model.system.Role;
import com.aurora.service.api.auth.AuthService;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 登录控制类
 * @author PHQ
 * @create 2020-05-03 12:22
 **/
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * 登录接口
     * @param user
     * @return
     */
    @PostMapping(value = "/login")
    @PassJwtToken
    @SystemLog(module="用户登录",methods="用户登录",url="/api/auth/login", desc="用户登录")
    @ApiOperation(value = "登录接口",notes = "登录接口需要用户对象",httpMethod = "POST")
    public ResultModel login(@Valid @RequestBody User user){

        ResultModel response = authService.login(user.getUsername(), user.getPassword());
        return response;
    }

    /**
     * 退出
     * @param request
     * @return
     */
    @GetMapping(value = "/logout")
    @PassJwtToken
    public ResultModel logout(HttpServletRequest request){
        String token = request.getHeader(tokenHeader);
        if (token == null) {
            return ResultModel.failure(ResultCode.UNAUTHORIZED);
        }
        authService.logout(token);
        return ResultModel.result(ResultCode.SUCCESS);
    }

    @GetMapping(value = "/user")
    public ResultModel getUser(HttpServletRequest request){
        String token = request.getHeader(tokenHeader);
        if (token == null) {
            return ResultModel.failure(ResultCode.UNAUTHORIZED);
        }
        User user = authService.getUserByToken(token);
        return ResultModel.successData(ResultCode.SUCCESS, user);
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping(value = "/sign")
    @SystemLog(module="用户权限模块",methods="用户注册",url="/api/v1/sign", desc="用户注册")
    @PassJwtToken
    public ResultModel sign(@RequestBody User user) {
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return ResultModel.failure(ResultCode.BAD_REQUEST);
        }
        User userDetail = new User(user.getUsername(), user.getPassword(), Role.builder().id(1).build());
        return ResultModel.successData(ResultCode.SUCCESS,authService.register(userDetail));
    }

    @GetMapping(value = "refresh")
    @ApiOperation(value = "刷新token")
    public ResultModel refreshAndGetAuthenticationToken(HttpServletRequest request){
        String token = request.getHeader(tokenHeader);
        ResponseUserToken response = authService.refresh(token);
        if(response == null) {
            return ResultModel.failure(ResultCode.BAD_REQUEST, "token无效");
        } else {
            return ResultModel.success();
        }
    }
}
