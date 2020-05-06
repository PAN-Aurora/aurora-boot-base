package com.aurora.service.service.auth;

import com.aurora.model.auth.UserDetail;
import com.aurora.model.system.Role;
import com.aurora.service.mapper.auth.AuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 登录权限校验的service
 * @author PHQ
 * @create 2020-05-03 11:37
 **/
@Component(value="CustomUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private final AuthMapper authMapper;

    public CustomUserDetailsService(AuthMapper authMapper) {
        this.authMapper = authMapper;
    }

    @Override
    public UserDetail loadUserByUsername(String name) throws UsernameNotFoundException {
        UserDetail userLogin = new UserDetail();
        userLogin.setUsername(name);
        //查询登录的用户
        UserDetail user = authMapper.findByUsername(userLogin);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", name));
        }
        //查询用户登录角色
        Role role = authMapper.findRoleByUserId(user);
        user.setRole(role);
        return user;
    }
}
