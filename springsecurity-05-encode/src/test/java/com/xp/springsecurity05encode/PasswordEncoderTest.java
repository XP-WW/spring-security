package com.xp.springsecurity05encode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/19 9:27
 * @since 1.0
 **/
@SpringBootTest
@Slf4j
public class PasswordEncoderTest {

    @Test
    @DisplayName("测试加密类BCryptPasswordEncoder")
    void testPassword() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //加密（明文到密文）
        String encode1 = bCryptPasswordEncoder.encode("123456");
        log.info("encode1:" + encode1);
        String encode2 = bCryptPasswordEncoder.encode("123456");
        log.info("encode2:" + encode2);
        String encode3 = bCryptPasswordEncoder.encode("123456");
        log.info("encode3:" + encode3);
        //匹配方法，判断明文经过加密后是否和密文一样
        boolean result1 = bCryptPasswordEncoder.matches("123456", encode1);
        boolean result2 = bCryptPasswordEncoder.matches("123456", encode1);
        boolean result3 = bCryptPasswordEncoder.matches("123456", encode1);
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
    }
}
