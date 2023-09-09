package com.xp.databaseauthentication.service.impl;

import com.xp.databaseauthentication.entity.User;
import com.xp.databaseauthentication.mapper.UserMapper;
import com.xp.databaseauthentication.service.UserService;
import com.xp.databaseauthentication.vo.SecurityUser;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountExpiredException;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 15:24
 * @since 1.0
 **/
@Service
@Slf4j
public class SecurityUserServiceImpl implements UserDetailsService {
    @Resource
    private UserService userService;
    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username==null) {
            throw new UsernameNotFoundException("未输入用户名");
        }
        User user = userService.getUser(username);
        if (user==null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        SecurityUser securityUser = new SecurityUser(user);
        if(!securityUser.isAccountNonExpired()){
            throw new AccountExpiredException("该用户已过期");
        }
        return securityUser;
    }
}
