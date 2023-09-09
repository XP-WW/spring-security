package com.xp.url.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 10:30
 * @since 1.0
 **/
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
