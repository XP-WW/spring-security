package com.xp.databaseauthentication.mapper;


import com.xp.databaseauthentication.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 14:47
 * @since 1.0
 **/
@Mapper
public interface UserMapper {
    /**
     * 根据用户名获取用户信息
     * @param username
     * @return User
     */
    User getUser(@Param("username") String username);
}
