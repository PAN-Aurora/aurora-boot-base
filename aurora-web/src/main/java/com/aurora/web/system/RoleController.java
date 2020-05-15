package com.aurora.web.system;

import com.aurora.common.model.ResultCode;
import com.aurora.common.model.ResultModel;
import com.aurora.config.annotation.SystemLog;
import com.aurora.model.system.Role;
import com.aurora.service.api.system.RoleService;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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



        /**
         * 保存角色
         * @param role
         * @return
         */
        @PostMapping(value = "/saveRole")
        @SystemLog(module="角色管理模块",methods="保存角色",url="/api/role/saveRole", desc="保存角色")
        @ApiOperation(value = "保存角色",notes = "保存角色",httpMethod = "POST")
        public ResultModel saveRole(@RequestBody Role role){
                if(role != null && StringUtils.isNotBlank(role.getName())){
                        return roleService.insertRole(role);
                }
                return ResultModel.failure(ResultCode.BAD_PARAMS);
        }

        /**
         * 修改角色
         * @param role
         * @return
         */
        @PostMapping(value = "/updateRole")
        @SystemLog(module="角色管理模块",methods="修改角色",url="/api/role/updateRole", desc="修改角色")
        @ApiOperation(value = "修改角色",notes = "修改角色",httpMethod = "POST")
        public ResultModel updateRole(@RequestBody Role role){
                if(role != null && StringUtils.isNotBlank(role.getName())){
                        return roleService.updateRole(role);
                }
                return ResultModel.failure(ResultCode.BAD_PARAMS);
        }
        /**
         * 刪除角色
         * @param role
         * @return
         */
        @PostMapping(value = "/deleteRole")
        @SystemLog(module="角色管理模块",methods="刪除角色",url="/api/role/deleteRole", desc="刪除角色")
        @ApiOperation(value = "刪除角色",notes = "刪除角色",httpMethod = "POST")
        public ResultModel deleteRole(@RequestBody Role role){
                if(role != null && role.getIds().length>0){
                        return roleService.deleteRole(role);
                }
                return ResultModel.failure(ResultCode.BAD_PARAMS);
        }
}
