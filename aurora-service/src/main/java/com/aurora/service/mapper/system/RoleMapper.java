package com.aurora.service.mapper.system;

import com.aurora.model.system.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * role mapper
 * @author PHQUser
 * @create 2020-05-01 22:14
 **/
@Repository
public interface RoleMapper extends BaseMapper<Role> {

}
