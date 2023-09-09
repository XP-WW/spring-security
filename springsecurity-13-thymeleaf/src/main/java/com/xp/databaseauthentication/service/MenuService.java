package com.xp.databaseauthentication.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 16:24
 * @since 1.0
 **/
public interface MenuService {
    List<String> queryPermissionsByUserId(Integer userId);
}
