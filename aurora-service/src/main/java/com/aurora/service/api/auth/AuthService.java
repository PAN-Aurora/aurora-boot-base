package com.aurora.service.api.auth;

import com.aurora.model.auth.ResponseUserToken;
import com.aurora.model.auth.UserDetail;

/**
 * 权限登录接口定义
 * @author PHQ
 * @create 2020-05-03 12:20
 **/
public interface AuthService {

    /**
     * 注册用户
     * @param userDetail
     * @return
     */
    UserDetail register(UserDetail userDetail);

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    ResponseUserToken login(String username, String password);

    /**
     * 登出
     * @param token
     */
    void logout(String token);

    /**
     * 刷新Token
     * @param oldToken
     * @return
     */
    ResponseUserToken refresh(String oldToken);

    /**
     * 根据Token获取用户信息
     * @param token
     * @return
     */
    UserDetail getUserByToken(String token);
}
