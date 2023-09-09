package com.xp.url.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                .requestMatchers("/login")
                .permitAll()
                .anyRequest()
                .authenticated()
        );
        http.formLogin(formLogin->formLogin
                .loginPage("/login")
                .permitAll()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/index")
        );

        /*http.csrf(Customizer.withDefaults());*/
        http.csrf(csrf->csrf.disable());//跨域漏洞防御：关闭


        http.logout(logout->logout.invalidateHttpSession(true));
        return http.build();
    }
    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().requestMatchers("/public/**").permitAll().anyRequest()
                .hasRole("USER").and()
                // Possibly more configuration ...
                .formLogin() // enable form based log in
                // set permitAll for all URLs associated with Form Login
                .permitAll();
        return http.build();
    }*/
    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/student/**")
                        .hasAnyAuthority("student:add","student:delete")
                        .requestMatchers("/teacher/**")
                        .hasAnyAuthority("ROLE_teacher")
                        .anyRequest()
                        .denyAll()
                        .anyRequest().permitAll()
                )
                .httpBasic(withDefaults());
        return http.build();
    }*/

}
