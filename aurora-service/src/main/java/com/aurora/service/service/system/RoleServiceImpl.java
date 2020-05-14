package com.aurora.service.service.system;

import com.alibaba.fastjson.JSON;
import com.aurora.common.model.ResultModel;
import com.aurora.model.system.Resource;
import com.aurora.model.system.Role;
import com.aurora.service.api.system.RoleService;
import com.aurora.service.mapper.system.ResourceMapper;
import com.aurora.service.mapper.system.RoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;

/**
 * ${DESCRIPTION}
 *
 * @author PHQ
 * @create 2020-05-01 22:45
 **/
@Service
public class RoleServiceImpl implements RoleService {
    private final static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ResourceMapper resourceMapper;


    /**
     * 查询用户列表
     * @param roleVo
     * @return
     */
    public ResultModel  getRoleList(Role roleVo){
        //分页参数
        Page<Role> page = new Page<>(roleVo.getCurrent(), roleVo.getLimit());
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        //查询参数
        if(StringUtils.isNotBlank(roleVo.getName())){
            queryWrapper.eq("name",roleVo.getName());
        }
        IPage<Role> userIPage =  roleMapper.selectPage(page,queryWrapper);
        List<Role> roleList =  userIPage.getRecords();

        //遍历角色获取菜单资源
        roleList.forEach(role -> {
            List<Resource> resourceList = resourceMapper.getResourceList(role.getId());
            role.setRosourceList(resourceList);
        });

        logger.info(userIPage.getTotal()+"");
        logger.info(JSON.toJSONString(roleList));
        return ResultModel.successPage(roleList,userIPage.getTotal());

    }
}
