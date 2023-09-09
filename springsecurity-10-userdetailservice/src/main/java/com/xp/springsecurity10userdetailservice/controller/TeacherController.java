package com.xp.springsecurity10userdetailservice.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 苏禾
 * @version 1.0
 * @Description <TODO description class purpose>
 * @createDate 2023/8/20 11:35
 * @since 1.0
 **/
@RestController
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {

    @GetMapping("/query")
    public String queryInfo() {
        return "I am a teacher,My name is ww!";
    }


}
