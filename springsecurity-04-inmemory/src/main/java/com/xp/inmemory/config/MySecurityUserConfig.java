package com.xp.inmemory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/18 21:57
 * @since 1.0
 **/
@Configuration
public class MySecurityUserConfig {
    @Bean
    public UserDetailsService userDetailService() {
        //使用org.springframework.security.core.userdetails.User类来定义用户
        //定义两个用户
        UserDetails user1 = User.builder().username("eric").password("123456").roles("student").build();
        UserDetails user2 = User.builder().username("thomas").password("123456").roles("teacher").build();
        //创建两个用户
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(user1);
        userDetailsManager.createUser(user2);
        return userDetailsManager;
    }
    /*
     * 从 Spring5 开始，强制要求密码要加密
     * 如果非不想加密，可以使用一个过期的 PasswordEncoder 的实例 NoOpPasswordEncoder，
     * 但是不建议这么做，毕竟不安全。
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        //不对密码进行加密，使用明文
        return NoOpPasswordEncoder.getInstance();
    }
}
