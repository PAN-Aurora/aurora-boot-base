package com.aurora.service.service.auth;

import com.aurora.common.model.ResultCode;
import com.aurora.common.model.ResultModel;
import com.aurora.common.util.JwtUtil;
import com.aurora.model.auth.ResponseUserToken;
import com.aurora.model.auth.User;
import com.aurora.model.system.Resource;
import com.aurora.model.system.Role;
import com.aurora.service.api.auth.AuthService;
import com.aurora.service.mapper.auth.AuthMapper;
import com.aurora.service.mapper.system.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * 权限登录接口实现
 * @author PHQ
 * @create 2020-05-03 12:31
 **/
@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtTokenUtil = new JwtUtil();

    @Autowired
    private  ResourceMapper resourceMapper;

    @Autowired
    private  AuthMapper authMapper;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, @Qualifier("CustomUserDetailsService") UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public User register(User user) {
        //校验用户
        if(authMapper.findByUsername(user)!=null) {
            //throw new CustomException(ResultModel.failure(ResultCode.BAD_REQUEST, "用户已存在"));
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = user.getPassword();

        user.setPassword(encoder.encode(rawPassword));
        user.setLastPasswordResetDate(new Date(System.currentTimeMillis()));
        //保存用户
        authMapper.insertUser(user);
        //获取用户角色
        long roleId = user.getRole().getId();
        Role role = authMapper.findRoleById(roleId);
        user.setRole(role);
        //保存用户和角色关系
        authMapper.insertRole(user.getId(), roleId);
        return user;
    }

    /**
     *  根据用户名和密码登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public ResultModel login(String username, String password) {
        //用户验证
        final Authentication authentication = authenticate(username, password);
        //存储认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //生成token
        final User user = (User) authentication.getPrincipal();

        final String token = jwtTokenUtil.generateAccessToken(user);
        //存储token
        jwtTokenUtil.putToken(username, token);
        //返回token与用户信息
        //return new ResponseUserToken(token, user);
        return  ResultModel.successData(ResultCode.SUCCESS, new ResponseUserToken(token, user));

    }

    @Override
    public void logout(String token) {
        token = token.substring(tokenHead.length());
        String userName = jwtTokenUtil.getUsernameFromToken(token);
        jwtTokenUtil.deleteToken(userName);
    }

    @Override
    public ResponseUserToken refresh(String oldToken) {
        String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        User user = (User) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
            token =  jwtTokenUtil.refreshToken(token);
            return new ResponseUserToken(token, user);
        }
        return null;
    }

    @Override
    public User getUserByToken(String token) {
        token = token.substring(tokenHead.length());
        return jwtTokenUtil.getUserFromToken(token);
    }

    /**
     * 获取用户详情信息
     * @param userLogin
     * @return
     */
    public User getUserInfo(User userLogin){
        //查询登录的用户
        User user = authMapper.findByUsername(userLogin);

        if(user!=null){
            //查询用户登录角色
            Role role = authMapper.findRoleByUserId(user);
            user.setRole(role);

            if(role!= null){
                //根据角色查询角色资源
                List<Resource> menuList =   resourceMapper.getResourceList(role.getId());
                user.setMenuList(menuList);
            }

        }



        return user;
    }

    private Authentication authenticate(String username, String password) {
        try {
            //该方法会去调用userDetailsService.loadUserByUsername()去验证用户名和密码，如果正确，则存储该用户名密码到“security 的 context中”
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        } catch (DisabledException | BadCredentialsException e) {
            throw e;
          //  throw new CustomException(ResultModel.failure(ResultCode.LOGIN_ERROR, e.getMessage()));
        }
    }
}
