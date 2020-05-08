package com.aurora.service.api.system;

import com.aurora.common.model.ResultModel;
import com.aurora.model.auth.User;

/**
 * 用户业务接口类
 * @author PHQ
 * @create 2020-05-01 22:43
 **/
public interface UserService {
    /**
     * 获取用户列表
     * @param user
     * @return
     */
    public ResultModel getUserList(User user);
}
