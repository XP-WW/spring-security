package com.xp.databaseauthentication.mapper;

import com.xp.databaseauthentication.entity.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 15:01
 * @since 1.0
 **/
@SpringBootTest
class UserMapperTest {

    @Resource
    private UserMapper userMapper;
    @Test
    void getUser() {
        User user = userMapper.getUser("obama");
        assertNotNull(user);
    }
}