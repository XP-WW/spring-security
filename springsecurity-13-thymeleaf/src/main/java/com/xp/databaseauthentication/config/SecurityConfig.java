package com.xp.databaseauthentication.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xp.databaseauthentication.filter.ValidateCodeFilter;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 15:37
 * @since 1.0
 **/
@Configuration
@Slf4j
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private ValidateCodeFilter validateCodeFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(form -> form
                .usernameParameter("uname") //页面表单的用户名的name
                .passwordParameter("pwd")//页面表单的密码的name
                .loginPage("/login/toLogin") //自己定义登陆页面的地址
                .loginProcessingUrl("/login/doLogin")//配置登陆的url
                .successForwardUrl("/index/toIndex") //登陆成功跳转的页面
                .failureForwardUrl("/login/toLogin")//登陆失败跳转的页面
                .permitAll());

        http.logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login/toLogin")
                .permitAll());

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/code/image")
                .permitAll()
                .anyRequest()
                .authenticated()
        );

        // 禁用csrf跨站请求攻击  后面可以使用postman工具测试，注意要禁用csrf
        http.csrf(AbstractHttpConfigurer::disable);

        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
