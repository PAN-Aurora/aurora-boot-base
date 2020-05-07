package com.aurora.service.service.system;

import com.aurora.service.api.system.UserService;
import com.aurora.service.mapper.auth.AuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现类
 * @author :PHQ
 * @date：2020/5/7
 **/
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private AuthMapper authMapper;


}
