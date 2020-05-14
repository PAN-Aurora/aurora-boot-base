package com.aurora.service.api.system;

import com.aurora.common.model.ResultModel;
import com.aurora.model.system.Role;

/**
 *
 * @author PHQ
 * @create 2020-05-01 22:44
 **/
public interface RoleService {

    //获取角色列表
    public ResultModel getRoleList(Role role);
}
