package com.xp.databaseauthentication.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 16:18
 * @since 1.0
 **/
@SpringBootTest
class MenuMapperTest {

    @Resource
    private MenuMapper menuMapper;
    @Test
    void queryPermissionsByUserId() {
        menuMapper.queryPermissionsByUserId(1);
    }
}