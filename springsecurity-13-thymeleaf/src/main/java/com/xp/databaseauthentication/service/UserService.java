package com.xp.databaseauthentication.service;

import com.xp.databaseauthentication.entity.User;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 15:08
 * @since 1.0
 **/
public interface UserService {
    /**
     * 根据用户名获取用户信息
     * @param username
     * @return User
     */
    User getUser(String username);
}
