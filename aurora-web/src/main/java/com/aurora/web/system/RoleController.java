package com.aurora.web.system;

import com.aurora.common.model.ResultModel;
import com.aurora.config.annotation.SystemLog;
import com.aurora.model.system.Role;
import com.aurora.service.api.system.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *  角色管理控制类
 * @author PHQ
 * @create 2020-05-14 22:01
 **/
@RestController
@RequestMapping("/api/role")
public class RoleController {
        @Autowired
        private RoleService roleService;

        /**
         * 获取角色列表
         * @param role
         * @return
         */
        @GetMapping(value = "/getRoleList")
        @SystemLog(module="角色管理模块",methods="获取角色列表",url="/api/role/getRoleList", desc="获取角色列表")
        @ApiOperation(value = "获取角色列表",notes = "获取角色列表分页列表数据",httpMethod = "GET")
        public ResultModel getRoleList(Role role){
                return roleService.getRoleList(role);
        }
}
