package com.xp.databaseauthentication.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 16:09
 * @since 1.0
 **/
@Mapper
public interface MenuMapper {
    List<String> queryPermissionsByUserId(@Param("userId") Integer userId);
}
