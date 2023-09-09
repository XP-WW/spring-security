package com.xp.url.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 10:46
 * @since 1.0
 **/
@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
