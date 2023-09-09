package com.xp.url.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        UserDetails user1 = User.builder()
                .username("xp")
                .password(passwordEncoder().encode("123456"))
                .roles("student")
                .authorities("student:delete","student:add")
                .build();
        UserDetails user2 = User.builder()
                .username("thomas")
                .password(passwordEncoder().encode("123456"))
                .authorities("teacher:delete","teacher:add")
                .roles("teacher")
                .build();
        //创建两个用户
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(user1);
        userDetailsManager.createUser(user2);
        return userDetailsManager;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
