package com.aurora.service.api.system;

import com.aurora.common.model.ResultModel;
import com.aurora.model.system.Resource;

/**
 * 资源业务接口
 * @author :PHQ
 * @date：2020/5/15
 **/
public interface ResourceService {

    /**
     * 获取资源集合
     * @param resource
     * @return
     */
    public ResultModel getResourceList(Resource resource);
}
