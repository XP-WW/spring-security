package com.xp.databaseauthentication.service.impl;

import com.xp.databaseauthentication.entity.User;
import com.xp.databaseauthentication.mapper.UserMapper;
import com.xp.databaseauthentication.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 15:09
 * @since 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public User getUser(String username) {
        return userMapper.getUser(username);
    }
}
