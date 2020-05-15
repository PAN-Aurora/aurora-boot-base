package com.aurora.service.service.system;

import com.alibaba.fastjson.JSON;
import com.aurora.common.model.ResultCode;
import com.aurora.common.model.ResultModel;
import com.aurora.model.auth.User;
import com.aurora.service.api.system.UserService;
import com.aurora.service.mapper.auth.AuthMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现类
 * @author :PHQ
 * @date：2020/5/7
 **/
@Service
public class UserServiceImpl implements UserService{

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private AuthMapper authMapper;

    public ResultModel   getUserList(User user){
        //分页参数
        Page<User> page = new Page<>(user.getCurrent(), user.getLimit());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //查询参数
        if(StringUtils.isNotBlank(user.getUsername())){
            queryWrapper.eq("username",user.getUsername());
        }
        IPage<User> userIPage =  authMapper.selectPage(page,queryWrapper);

        logger.info(userIPage.getTotal()+"");
        logger.info(JSON.toJSONString(userIPage.getRecords()));
        return ResultModel.successPage(userIPage.getRecords(),userIPage.getTotal());
    }




}
