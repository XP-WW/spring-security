package com.xp.databaseauthentication.service.impl;

import com.xp.databaseauthentication.entity.User;
import com.xp.databaseauthentication.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 15:12
 * @since 1.0
 **/
@SpringBootTest
class UserServiceImplTest {

    @Resource
    private UserService userService;
    @Test
    void getUser() {
        User user = userService.getUser("ddd");
        assertNull(user);
    }
}