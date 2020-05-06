package com.aurora.service.mapper.auth;

import com.aurora.model.auth.UserDetail;
import com.aurora.model.system.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;


/**
 *  登录相关操作的mapper
 * @author PHQ
 * @create 2020-05-03 11:39
 **/
public interface AuthMapper  extends BaseMapper<UserDetail> {
    /**
     * 通过用户名 查询用户信息
     * @param user
     * @return
     */
    public UserDetail findByUsername(UserDetail user);

    /**
     * 通过用户id 查询对象的角色列表
     * @param user
     * @return
     */
    public Role findRoleByUserId(UserDetail user);


    /**
     * 创建新用户
     * @param userDetail
     */
    void saveUser(UserDetail userDetail);

    /**
     * 创建用户角色
     * @param userId
     * @param roleId
     * @return
     */
    int insertRole(@Param("userId") long userId, @Param("roleId") long roleId);

    /**
     * 根据角色id查找角色
     * @param roleId
     * @return
     */
    Role findRoleById(@Param("roleId") long roleId);

}
