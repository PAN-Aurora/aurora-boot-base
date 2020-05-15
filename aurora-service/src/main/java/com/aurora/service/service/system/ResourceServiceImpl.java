package com.aurora.service.service.system;

import com.alibaba.fastjson.JSON;
import com.aurora.common.model.ResultModel;
import com.aurora.model.system.Resource;
import com.aurora.service.api.system.ResourceService;
import com.aurora.service.mapper.system.ResourceMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 资源管理
 * @author :PHQ
 * @date：2020/5/15
 **/
@Service
public class ResourceServiceImpl  implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 查询用户列表
     * @return
     */
    public ResultModel getResourceList(Resource resource){
        //分页参数
        Page<Resource> page = new Page<>(resource.getCurrent(), resource.getLimit());
        QueryWrapper<Resource> queryWrapper = new QueryWrapper<>();
        //查询参数
        if(StringUtils.isNotBlank(resource.getName())){
            queryWrapper.eq("name",resource.getName());
        }
        IPage<Resource> userIPage =  resourceMapper.selectPage(page,queryWrapper);
        List<Resource> roleList =  userIPage.getRecords();

        return ResultModel.successPage(roleList,userIPage.getTotal());

    }


}
