package com.xp.databaseauthentication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 17:27
 * @since 1.0
 **/
@Controller
@Slf4j
@RequestMapping("/login")
public class LoginController {
    @GetMapping("/toLogin")
    public String login(){
        return "login";
    }
}
