package com.xp.databaseauthentication.service.impl;

import com.xp.databaseauthentication.mapper.MenuMapper;
import com.xp.databaseauthentication.service.MenuService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 16:25
 * @since 1.0
 **/
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;
    @Override
    public List<String> queryPermissionsByUserId(Integer userId) {
        return menuMapper.queryPermissionsByUserId(userId);
    }
}
