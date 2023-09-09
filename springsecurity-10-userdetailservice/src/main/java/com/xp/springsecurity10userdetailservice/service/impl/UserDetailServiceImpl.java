package com.xp.springsecurity10userdetailservice.service.impl;

import com.xp.springsecurity10userdetailservice.vo.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 14:13
 * @since 1.0
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!StringUtils.hasText(username)) {
            throw new UsernameNotFoundException("请输入用户名！");
        }
        if(!username.equals("xp")){
            throw new UsernameNotFoundException("用户名不存在！");
        }
        return new SecurityUser();
    }
}
