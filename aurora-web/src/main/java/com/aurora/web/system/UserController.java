package com.aurora.web.system;

import com.aurora.common.model.ResultCode;
import com.aurora.common.model.ResultModel;
import com.aurora.config.annotation.PassJwtToken;
import com.aurora.config.annotation.SystemLog;
import com.aurora.model.auth.User;
import com.aurora.service.api.system.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户管理
 * @author :PHQ
 * @date：2020/5/7
 **/
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     * @param user
     * @return
     */
    @GetMapping(value = "/getUserList")
    @SystemLog(module="用户管理模块",methods="获取用户列表",url="/api/user/getUserList", desc="获取用户分页列表数据")
    @ApiOperation(value = "获取用户列表",notes = "获取用户分页列表数据",httpMethod = "GET")
    public ResultModel getUserList(User user){
        return userService.getUserList(user);
    }
}
