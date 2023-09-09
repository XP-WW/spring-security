package com.xp.databaseauthentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 17:35
 * @since 1.0
 **/
@Controller
@RequestMapping("/index")
public class IndexController {

    /**
     * 登录成功后进入主页
     */
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "main";
    }
}
