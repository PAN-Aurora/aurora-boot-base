package com.aurora.web.system;

import com.aurora.common.model.ResultModel;
import com.aurora.config.annotation.SystemLog;
import com.aurora.model.system.Resource;
import com.aurora.service.api.system.ResourceService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 菜单资源控制类
 * @author :PHQ
 * @date：2020/5/15
 **/
@RestController
@RequestMapping("/api/resource")
public class ResourceController {

     @Autowired
     private ResourceService resourceService;


    /**
     * 资源列表
     * @param resource
     * @return
     */
    @GetMapping(value = "/getResourceList")
    @SystemLog(module="资源管理模块",methods="获取资源集合",url="/api/resource/getResourceList", desc="获取资源集合")
    @ApiOperation(value = "获取资源集合",notes = "获取资源集合分页列表数据",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "resource", value = "资源实体对象 resource", required = true, dataType = "com.aurora.model.auth.Resource")
    })
    public ResultModel getResourceList(Resource resource){
        return resourceService.getResourceList(resource);
    }
}
