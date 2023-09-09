package com.xp.springsecurity05encode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/18 17:55
 * @since 1.0
 **/
@RestController
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/query")
    public String queryInfo(){
        return "I am a student,My name is Eric!";
    }
}
