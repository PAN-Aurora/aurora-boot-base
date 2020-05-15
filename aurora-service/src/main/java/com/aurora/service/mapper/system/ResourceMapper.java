package com.aurora.service.mapper.system;

import com.aurora.model.system.Resource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 资源mapper
 * @author :PHQ
 * @date：2020/5/8
 **/
@Repository
public interface ResourceMapper extends BaseMapper<Resource> {

    public List<Resource> getResourceListByRoleId(@Param("roleId") long roleId);

}
