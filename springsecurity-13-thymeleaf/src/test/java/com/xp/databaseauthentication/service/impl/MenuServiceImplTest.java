package com.xp.databaseauthentication.service.impl;

import com.xp.databaseauthentication.service.MenuService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 16:48
 * @since 1.0
 **/
@SpringBootTest
class MenuServiceImplTest {

    @Resource
    private MenuService menuService;
    @Test
    void queryPermissionsByUserId() {
        menuService.queryPermissionsByUserId(1);
    }
}